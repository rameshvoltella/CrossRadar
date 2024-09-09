package com.open.levelcrossapp.data.formatter.confirmticket

import android.util.Log
import com.open.levelcrossapp.data.dto.DaysOfRun
import com.open.levelcrossapp.data.dto.TrainInStation
import com.open.levelcrossapp.data.dto.TrainInfo
import com.open.levelcrossapp.data.formatter.base.FormattedData
import com.open.levelcrossapp.data.formatter.base.FormattedResult
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConfirmTicketDataFormatter @Inject constructor():
    FormattedData<String, FormattedResult<TrainInStation, Exception>>() {

    override suspend fun runFormatting(htmlContent: String): FormattedResult<TrainInStation, Exception> {
        Log.d("papap", "yes3")

        val pattern = Pattern.compile("""data\s*=\s*(\[\{.*?\}\]);""")
        val matcher = pattern.matcher(htmlContent)

        if (matcher.find()) {
            val jsonArrayString = matcher.group(1)
            Log.d("poda", jsonArrayString ?: "No JSON array found")

            // Step 2: Parse the JSON array string into a Kotlin data class list
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory()) // Add this line
                .build()
            val listType = Types.newParameterizedType(List::class.java, TrainInfo::class.java)
            val adapter: JsonAdapter<List<TrainInfo>> = moshi.adapter(listType)

            return try {
                val trainInfoList =getTrainsForToday( jsonArrayString?.let { adapter.fromJson(it) })

                if (trainInfoList != null) {
                    FormattedResult.SUCCESS(TrainInStation(trainInfoList))
                } else {
                    FormattedResult.ERROR(Exception("Failed to parse JSON"))
                }
            } catch (e: Exception) {
                Log.e("FormattingError", "Error parsing JSON: ${e.message}", e)
                FormattedResult.ERROR(e)
            }
        } else {
            return FormattedResult.ERROR(Exception("No matching data found in HTML"))
        }
    }

    fun getTrainsForToday(trainList: List<TrainInfo>?): List<TrainInfo> {
        // Map day names to their corresponding boolean properties in DaysOfRun
        val dayMap = mapOf(
            "Sun" to { daysOfRun: DaysOfRun -> daysOfRun.Sun },
            "Mon" to { daysOfRun: DaysOfRun -> daysOfRun.Mon },
            "Tue" to { daysOfRun: DaysOfRun -> daysOfRun.Tue },
            "Wed" to { daysOfRun: DaysOfRun -> daysOfRun.Wed },
            "Thu" to { daysOfRun: DaysOfRun -> daysOfRun.Thu },
            "Fri" to { daysOfRun: DaysOfRun -> daysOfRun.Fri },
            "Sat" to { daysOfRun: DaysOfRun -> daysOfRun.Sat }
        )

        // Assume currentDay is the current day of the week as a string (e.g., "Mon")
        val currentDay = getCurrentDay() // Implement this method to get the current day as a string

        return trainList?.filter { train ->
            Log.d("dd","popop"+train.TrainNo)
            dayMap[currentDay]?.invoke(train.DaysOfRun) == true
        } ?: emptyList()
    }

    // Implement this method to return the current day of the week as a string
    fun getCurrentDay(): String {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return when (dayOfWeek) {
            Calendar.SUNDAY -> "Sun"
            Calendar.MONDAY -> "Mon"
            Calendar.TUESDAY -> "Tue"
            Calendar.WEDNESDAY -> "Wed"
            Calendar.THURSDAY -> "Thu"
            Calendar.FRIDAY -> "Fri"
            Calendar.SATURDAY -> "Sat"
            else -> "Sun" // Default to "Sun" if something goes wrong
        }
    }

}
