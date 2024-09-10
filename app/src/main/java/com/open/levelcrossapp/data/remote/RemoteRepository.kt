package com.open.levelcrossapp.data.remote

import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.data.dto.TrainDetails
import com.open.levelcrossapp.data.dto.TrainInStation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepository@Inject constructor(
    private val remoteRepository: RemoteData,
) : RemoteRepositorySource {
    override suspend fun getTrainByStation(url: String): Flow<Resource<TrainInStation>> {

        return flow { emit(remoteRepository.getTrainByStation(url)) }

    }

    override suspend fun getCrossStatus(trainInfo: TrainInStation): Flow<Resource<TrainDetails>> {
        return flow { emit(remoteRepository.getCrossStatus(trainInfo)) }
    }
}

