package com.open.levelcrossapp.data.remote

import android.util.Log
import com.open.levelcrossapp.data.NetworkConnectivity
import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.data.dto.TrainInStation
import com.open.levelcrossapp.data.formatter.base.FormattedResult
import com.open.levelcrossapp.data.formatter.confirmticket.ConfirmTickedTrainDataFormatterFactory
import com.open.levelcrossapp.data.remote.api.ApiServices
import com.open.levelcrossapp.data.remote.api.ServiceGenerator
import com.open.levelcrossapp.errors.NETWORK_ERROR
import com.open.levelcrossapp.errors.NO_INTERNET_CONNECTION
import com.open.levelcrossapp.errors.SERVER_ERROR
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity,
    private val confirmTickedTrainDataFormatterFactory: ConfirmTickedTrainDataFormatterFactory
) : RemoteDataSource {
    override suspend fun getTrainByStation(url: String): Resource<TrainInStation> {
        Log.d("papap","yes")
        val apiService = serviceGenerator.createService(ApiServices::class.java)

        return when (val response = processCall {
            apiService.getTrainInStation(
                url
            )
        }) {
            is Any -> {
                try {
                    (response is String).let {
                        Log.d("papap","yes2")

                        val result =
                            confirmTickedTrainDataFormatterFactory.getTrainPassingThroughStation()
                                .run(response as String)

                        return when (result) {
                            is FormattedResult.SUCCESS -> {
                                Log.d("papap","yessucesss")

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
}