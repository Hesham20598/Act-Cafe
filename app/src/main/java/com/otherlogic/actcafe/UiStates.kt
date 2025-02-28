package com.otherlogic.actcafe

sealed class UiStates<out T> {
     object Idle : UiStates<Nothing>()
     object Loading : UiStates<Nothing>()
    data class Success<out T>(val data: T) : UiStates<T>()
    data class Error(val exception: String) : UiStates<Nothing>()
}