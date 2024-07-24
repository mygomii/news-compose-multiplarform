package com.example.composeApp.presentation.events

import com.example.composeApp.data.models.Source

sealed class MainUIState {
    data object Loading : MainUIState()
    data class Success(val sources: List<Source>) : MainUIState()
    data object Error : MainUIState()
}
