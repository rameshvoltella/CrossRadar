package com.open.levelcrossapp.data.formatter.confirmticket

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ConfirmTickedTrainDataFormatterFactory @Inject constructor() {

    fun getTrainPassingThroughStation():ConfirmTicketDataFormatter
    {
        return ConfirmTicketDataFormatter()
    }
}