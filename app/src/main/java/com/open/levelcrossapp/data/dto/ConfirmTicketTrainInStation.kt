package com.open.levelcrossapp.data.dto

data class TrainInfo(
    val TrainName: String,
    val TrainNo: String,
    val ArrivalTime: String,
    val DepartureTime: String,
    val Classes: List<String>,
    val DaysOfRun: DaysOfRun
)

data class DaysOfRun(
    val Sun: Boolean,
    val Mon: Boolean,
    val Tue: Boolean,
    val Wed: Boolean,
    val Thu: Boolean,
    val Fri: Boolean,
    val Sat: Boolean
)