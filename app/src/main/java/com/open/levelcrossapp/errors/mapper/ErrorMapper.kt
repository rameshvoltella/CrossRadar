package com.open.levelcrossapp.errors.mapper

import android.content.Context
import com.open.levelcrossapp.R
import com.open.levelcrossapp.errors.NETWORK_ERROR
import com.open.levelcrossapp.errors.NO_INTERNET_CONNECTION

import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapper @Inject constructor(@ApplicationContext val context: Context) :
    ErrorMapperSource {

    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getErrorString(R.string.no_internet)),
            Pair(NETWORK_ERROR, getErrorString(R.string.network_error))

        ).withDefault { getErrorString(R.string.network_error) }
}
