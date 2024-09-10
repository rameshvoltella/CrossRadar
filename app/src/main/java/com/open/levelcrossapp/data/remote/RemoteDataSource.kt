package com.open.levelcrossapp.data.remote

import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.data.dto.TrainDetails
import com.open.levelcrossapp.data.dto.TrainInStation

interface RemoteDataSource {

    suspend fun getTrainByStation(url:String) : Resource<TrainInStation>
    suspend fun getCrossStatus(trainInfo:TrainInStation) : Resource<TrainDetails>

}