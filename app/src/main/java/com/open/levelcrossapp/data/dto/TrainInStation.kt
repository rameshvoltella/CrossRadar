package com.open.levelcrossapp.data.dto

data class TrainInStation(val trainList: List<TrainInfo>?)

data class TrainDetails(val isLevelCrossLocked:Boolean=false,val details:String="")