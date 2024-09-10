package com.open.levelcrossapp.data.remote

import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.data.dto.TrainDetails
import com.open.levelcrossapp.data.dto.TrainInStation
import kotlinx.coroutines.flow.Flow

interface RemoteRepositorySource {

    suspend fun getTrainByStation(url:String) : Flow<Resource<TrainInStation>>
    suspend fun getCrossStatus(trainInfo:TrainInStation) : Flow<Resource<TrainDetails>>


}