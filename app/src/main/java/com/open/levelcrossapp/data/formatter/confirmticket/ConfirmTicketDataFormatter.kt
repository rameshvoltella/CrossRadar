package com.open.levelcrossapp.data.formatter.confirmticket

import com.open.levelcrossapp.data.dto.ConfirmTicketTrainInStation
import com.open.levelcrossapp.data.dto.TrainInStation
import com.open.levelcrossapp.data.formatter.base.FormattedData
import com.open.levelcrossapp.data.formatter.base.FormattedResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConfirmTicketDataFormatter @Inject constructor():
    FormattedData<ConfirmTicketTrainInStation, FormattedResult<TrainInStation, Exception>>() {
    override suspend fun runFormatting(input: ConfirmTicketTrainInStation): FormattedResult<TrainInStation, Exception> {
        return FormattedResult.ERROR(Exception())
    }


}