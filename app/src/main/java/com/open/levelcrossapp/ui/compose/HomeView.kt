package com.open.levelcrossapp.ui.compose

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.viewmodel.AppViewmodel


@Composable
fun HomeScreen(viewmodel: AppViewmodel = hiltViewModel()) {

    val trainInStation by viewmodel.getTrainPassingThroughStation.observeAsState()

    LaunchedEffect(key1 = Unit) {
        viewmodel.getTrainPassingThroughStation("https://www.confirmtkt.com/station/VARD")
    }

    LaunchedEffect(key1 = trainInStation) {
        if (trainInStation is Resource.Success) {
            Log.d("valala", "" + trainInStation!!.data?.trainList?.size)
        }

    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = androidx.compose.ui.Modifier.fillMaxSize()
    ) {
        Text(
            text = "Hello, World!",
            fontSize = 24.sp
        )
    }

}




