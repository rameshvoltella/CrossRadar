package com.open.levelcrossapp.data.formatter.base

sealed class FormattedResult <out RESULT,out ERROR>{

    data class SUCCESS<out RESULT>(val data:RESULT) :FormattedResult<RESULT,Nothing>()
    data class ERROR<out ERROR>(val error:ERROR) :FormattedResult<Nothing,ERROR>()

}