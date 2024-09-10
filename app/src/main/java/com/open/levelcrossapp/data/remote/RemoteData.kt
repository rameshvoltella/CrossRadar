package com.open.levelcrossapp.data.remote

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.open.levelcrossapp.data.NetworkConnectivity
import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.data.dto.TrainDetails
import com.open.levelcrossapp.data.dto.TrainInStation
import com.open.levelcrossapp.data.formatter.base.FormattedResult
import com.open.levelcrossapp.data.formatter.confirmticket.ConfirmTickedTrainDataFormatterFactory
import com.open.levelcrossapp.data.remote.api.ApiServices
import com.open.levelcrossapp.data.remote.api.ServiceGenerator
import com.open.levelcrossapp.errors.NETWORK_ERROR
import com.open.levelcrossapp.errors.NO_INTERNET_CONNECTION
import com.open.levelcrossapp.errors.SERVER_ERROR
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import retrofit2.Response
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity,
    private val confirmTickedTrainDataFormatterFactory: ConfirmTickedTrainDataFormatterFactory
) : RemoteDataSource {
    fun getCurrentFormattedDate(): String {
        val dateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    override suspend fun getTrainByStation(url: String): Resource<TrainInStation> {
        Log.d("papap", "yes")
        val apiService = serviceGenerator.createService(ApiServices::class.java)

        return when (val response = processCall {
            apiService.getTrainInStation(
                url
            )
        }) {
            is Any -> {
                try {
                    (response is String).let {
                        Log.d("papap", "yes2")

                        val result =
                            confirmTickedTrainDataFormatterFactory.getTrainPassingThroughStation()
                                .run(response as String)

                        return when (result) {
                            is FormattedResult.SUCCESS -> {
                                Log.d("papap", "yessucesss")

                                Resource.Success(result.data)
                            }

                            is FormattedResult.ERROR -> {
                                Resource.DataError(404)
                            }

                        }
//                        val result = youtubeV3Formatter.run(response as YoutubeSearchResponse)
//                        return when (result) {
//                            is FormattingResult.SUCCESS -> {
//                                Resource.Success(result.data)
//                            }
//
//                            is FormattingResult.FAILURE -> {
//                                Resource.DataError(YOUTUBE_V3_SEARCH_ERROR)
//                            }
//
//                        }
//                        Resource.Success(result)
//                        Resource.DataError(YOUTUBE_V3_SEARCH_ERROR)
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                    Resource.DataError(404)
                }
            }

            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    override suspend fun getCrossStatus(trainInfo: TrainInStation): Resource<TrainDetails> {
        val apiService = serviceGenerator.createService(ApiServices::class.java)

        return withContext(Dispatchers.IO) {
            var isLevelCrossOpen = true
            var currentdetails = "No Trains"
            val formatter = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
            val passangers = arrayListOf(
                "06777",
                "06453",
                "16309",
                "06769",
                "06443",
                "06444",
                "06768",
                "06778",
                "16310",
                "06434",
                "06442"
            )
            val passangersTime = arrayListOf(
                "07:28",
                "09:30",
                "10:10",
                "14:58",
                "19:43",
                "06:25",
                "10:00",
                "13:03",
                "16:25",
                "17:20",
                "23:00"
            )


            for (i in passangers.indices) {
                val passenger = passangers[i]
                val time = passangersTime[i]
                println("Passenger ID: $passenger, Time: $time")
                Log.d("ppppko","https://www.goibibo.com/trains/app/trainstatus/results/?train=" + passenger )
                if (isWithinTwoHoursOf(time)) {

                    val response = processCall {
                        apiService.getTrainStatus(
                            "https://www.goibibo.com/trains/app/trainstatus/results/?train=" + passenger
                        )
                    }
                    Log.d(
                        "chakkuzo IBIBI->",
                        "" + passenger + "<><>" + passenger + "<><<>" + time
                    )
                    val currentStationcode = getStationFromGibbo(response as String)
                    if (currentStationcode.equals("VARD") || currentStationcode.equals("KDTY") || currentStationcode.equals(
                            "ETM"
                        ) || currentStationcode.equals("KRPP") ||  currentStationcode.equals("PVRD")
                    ) {
                        currentdetails =
                            passenger + "<>" + "PASSENGER" + "<>" + currentStationcode
                        isLevelCrossOpen = false
                        break
                    }
                }
            }
            if (isLevelCrossOpen) {

                for (trainN in trainInfo.trainList!!) {

                    if (isWithinTwoHoursOf(trainN.ArrivalTime)) {
                        for (i in 2 downTo 0) {
                            val calendar = Calendar.getInstance()
                            calendar.add(Calendar.DAY_OF_YEAR, -i)
                            val date = calendar.time//
                            //               println("Date ${3 - i}: ${date.format(formatter)}")
                            val response = processCall {
                                apiService.getTrainInStation(
                                    "https://www.confirmtkt.com/train-running-status/" + trainN.TrainNo + "?Date=${
                                        formatter.format(
                                            date
                                        )
                                    }"
                                )
                            }
                            val currentStationcode = extractCurrentStnCode(response as String)
                            Log.d(
                                "chakkuzo CNF->",
                                "" + trainN.TrainNo + "<><>" + formatter.format(date) + "<><<>" + currentStationcode
                            )

                            if (currentStationcode.equals("VARD") || currentStationcode.equals("KDTY") || currentStationcode.equals(
                                    "ETM"
                                ) || currentStationcode.equals("KRPP")|| currentStationcode.equals("PVRD")
                            ) {
                                currentdetails =
                                    trainN.TrainNo + "<>" + trainN.TrainName + "<>" + currentStationcode
                                isLevelCrossOpen = false
                                break
                            }
                        }
                    }
                    if (!isLevelCrossOpen) {
                        break
                    }

                }
            }
            Resource.Success(TrainDetails(isLevelCrossOpen, currentdetails))

        }


    }


    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        try {
            if (!networkConnectivity.isConnected()) {
                return NO_INTERNET_CONNECTION
            }
            return try {
                val response = responseCall.invoke()
                val responseCode = response.code()
                if (response.isSuccessful) {

                    response.body()
                } else {
                    responseCode
                }
            } catch (e: IOException) {
                e.printStackTrace()
                NETWORK_ERROR
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return SERVER_ERROR
        }
    }

    fun extractCurrentStnCode(htmlData: String): String? {
        val regex = """var\s+currentStnCode\s*=\s*"([^"]*)"""".toRegex()
        val matchResult = regex.find(htmlData)
        return matchResult?.groupValues?.get(1)
    }


    fun isWithinTwoHoursBefore(targetTime: String): Boolean {
        Log.d("chakkuz", "ARRIVAL" + targetTime)
        try {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            // Get current time
            val currentTime = Calendar.getInstance()

            // Parse target time (15:30) and set it to the current date
            val targetCalendar = Calendar.getInstance().apply {
                time = timeFormat.parse(targetTime)
                set(Calendar.YEAR, currentTime.get(Calendar.YEAR))
                set(Calendar.MONTH, currentTime.get(Calendar.MONTH))
                set(Calendar.DAY_OF_MONTH, currentTime.get(Calendar.DAY_OF_MONTH))
            }

            // Subtract 2 hours from the target time
            targetCalendar.add(Calendar.HOUR_OF_DAY, -3)

            // Check if current time is after or equal to the calculated time and before the target time
            return currentTime.after(targetCalendar) && currentTime.before(
                Calendar.getInstance().apply {
                    time = timeFormat.parse(targetTime)
                    set(Calendar.YEAR, currentTime.get(Calendar.YEAR))
                    set(Calendar.MONTH, currentTime.get(Calendar.MONTH))
                    set(Calendar.DAY_OF_MONTH, currentTime.get(Calendar.DAY_OF_MONTH))
                })
        } catch (ex: Exception) {
            return false
        }
    }

    fun isWithinTwoHoursOf(targetTime: String): Boolean {
        Log.d("chakkuz", "TARGET TIME: $targetTime")
        try {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            // Get current time
            val currentTime = Calendar.getInstance()

            // Parse target time and set it to the current date
            val targetCalendar = Calendar.getInstance().apply {
                time = timeFormat.parse(targetTime)
                set(Calendar.YEAR, currentTime.get(Calendar.YEAR))
                set(Calendar.MONTH, currentTime.get(Calendar.MONTH))
                set(Calendar.DAY_OF_MONTH, currentTime.get(Calendar.DAY_OF_MONTH))
            }

            // Create calendar instances for 2 hours before and after the target time
            val twoHoursBeforeTarget = targetCalendar.clone() as Calendar
            twoHoursBeforeTarget.add(Calendar.HOUR_OF_DAY, -2)

            val twoHoursAfterTarget = targetCalendar.clone() as Calendar
            twoHoursAfterTarget.add(Calendar.HOUR_OF_DAY, 2)

            // Check if the current time is within the 2-hour window
            return currentTime.after(twoHoursBeforeTarget) && currentTime.before(twoHoursAfterTarget)
        } catch (ex: Exception) {
            Log.e("chakkuz", "Error parsing time", ex)
            return false
        }
    }

    fun getStationFromGibbo(html:String):String
    {

        try {
            val document = Jsoup.parse(html)

            // Select the div with class "respNxtDtls"
            val divElement = document.select("div.respNxtDtls")

            // Extract the text from the first <p> tag within the div
            val stationName = divElement.select("p.boldFont").first()?.text()

            // Split the text by comma and take the first part (KRPP)
            val stationCode = stationName?.split(",")?.get(0)?.trim()
            println("KITTIYO: $stationCode")

            return stationCode+""
        }catch (ex:Exception)
        {
            return ""
        }

        // Print the result
    }

}