package com.example.composeApp.presentation.events

interface BaseUIState {
    data object Loading : BaseUIState
    data class Success<T>(val contents: List<T>) : BaseUIState
    data object Error : BaseUIState
}