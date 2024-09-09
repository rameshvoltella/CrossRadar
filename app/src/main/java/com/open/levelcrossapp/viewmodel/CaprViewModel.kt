package com.open.levelcrossapp.viewmodel

import androidx.lifecycle.ViewModel
import com.open.levelcrossapp.data.remote.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CaprViewModel@Inject constructor(val remoteRepository: RemoteRepository)  : ViewModel() {

    private val itemCountPrivate = MutableStateFlow(0)
    val itemCount = itemCountPrivate.asStateFlow()


    fun addCount(count: Int) {
        itemCountPrivate.value = count
    }
}