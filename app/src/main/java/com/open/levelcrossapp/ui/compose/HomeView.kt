package com.open.levelcrossapp.ui.compose

import android.app.Activity
import android.util.Log
import android.view.WindowManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.open.levelcrossapp.data.Resource
import com.open.levelcrossapp.viewmodel.AppViewmodel


@Composable
fun HomeScreen(viewmodel: AppViewmodel = hiltViewModel()) {

    val trainInStation by viewmodel.getTrainPassingThroughStation.observeAsState()
    val isCross by viewmodel.getTrainCross.observeAsState()

    var apiStarted= remember {
        mutableStateOf(false)
    }

    var levelcrosssStatus= remember {
        mutableStateOf(false)
    }

    var wait= remember {
        mutableStateOf("WAIT...")
    }
    val context = LocalContext.current

    DisposableEffect(Unit) {
        val activity = context as? Activity
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        onDispose {
            activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }

    LaunchedEffect(key1 = Unit) {
        if(!apiStarted.value) {
            viewmodel.getTrainPassingThroughStation("https://www.confirmtkt.com/station/KTYM")
        }
    }

    LaunchedEffect(key1 = trainInStation) {
        if (trainInStation is Resource.Success) {
            Log.d("valala", "" + trainInStation!!.data?.trainList?.size)
            apiStarted.value=true
            viewmodel.checkFOrLevelCross(trainInStation?.data!!)
        }

    }

    LaunchedEffect(key1 = isCross) {
        if (isCross is Resource.Success) {
            Log.d("valala", "" + isCross!!.data?.details)
            wait.value=isCross!!.data?.details!!
            levelcrosssStatus.value=true
//            viewmodel.checkFOrLevelCross(trainInStation?.data!!)
        }

    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = androidx.compose.ui.Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = wait.value,
                fontSize = 24.sp
            )
            Button(
                onClick = {
                    wait.value="RELOADING WAIT...."
                    viewmodel.getTrainPassingThroughStation("https://www.confirmtkt.com/station/KTYM")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Add horizontal padding
            ) {
                Text(text = "Click Me")
            }
        }
    }

}




