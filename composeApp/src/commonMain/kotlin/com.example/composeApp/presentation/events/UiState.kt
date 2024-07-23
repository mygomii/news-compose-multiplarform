package com.example.composeApp.presentation.events

import com.example.composeApp.data.models.Article

sealed class UiState {
    data object Loading : UiState()
    data class Success(val articles: List<Article>) : UiState()
    data object Error : UiState()
}