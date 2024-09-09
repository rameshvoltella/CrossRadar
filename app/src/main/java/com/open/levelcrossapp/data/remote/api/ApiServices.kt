package com.open.levelcrossapp.data.remote.api

import com.open.levelcrossapp.data.dto.TrainInStation

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiServices {

    @GET
    suspend fun getTrainInStation(
        @Url url: String
    ) : Response<TrainInStation>

}