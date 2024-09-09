package com.open.levelcrossapp.data.formatter.base

abstract class FormattedData<in INPUT,out OUTPUT> {

    protected abstract suspend fun runFormatting(input:INPUT):OUTPUT

    suspend fun run(input: INPUT):OUTPUT{return runFormatting(input)}

}