package com.jgeun.aftest.common_ui.result

sealed class UiState<out R> {
    data class Success<T>(val data: T): UiState<T>()
    object Loading: UiState<Nothing>()

    override fun toString(): String {
        return when(this) {
            is Success<*> -> "Success[data=$data]"
            Loading -> "Loading"
        }
    }
}

val <T> UiState<T>.data: T?
    get() = (this as? UiState.Success)?.data