package com.open.levelcrossapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.data.dto.TrainDetails
import com.open.levelcrossapp.data.dto.TrainInStation
import com.open.levelcrossapp.data.remote.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AppViewmodel @Inject constructor(val remoteRepository: RemoteRepository) : ViewModel()  {
    val getTrainPassingThroughStationPrivate =MutableLiveData<Resource<TrainInStation>>()
    val getTrainPassingThroughStation :LiveData<Resource<TrainInStation>>get()=getTrainPassingThroughStationPrivate

    val getTrainCrossPrivate =MutableLiveData<Resource<TrainDetails>>()
    val getTrainCross :LiveData<Resource<TrainDetails>>get()=getTrainCrossPrivate



    fun getTrainPassingThroughStation(url:String)
    {
        viewModelScope.launch {
            remoteRepository.getTrainByStation(url).collect{
                getTrainPassingThroughStationPrivate.value=it
            }
        }
    }

    fun checkFOrLevelCross(trains:TrainInStation)
    {
        viewModelScope.launch {
            remoteRepository.getCrossStatus(trains).collect{
                getTrainCrossPrivate.value=it
            }
        }
    }
}