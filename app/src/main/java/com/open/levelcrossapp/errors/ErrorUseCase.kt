package com.open.levelcrossapp.errors


interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}
