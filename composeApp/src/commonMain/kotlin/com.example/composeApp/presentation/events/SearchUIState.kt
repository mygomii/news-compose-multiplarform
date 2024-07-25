package com.example.composeApp.presentation.events

import com.example.composeApp.data.models.Article

sealed class SearchUIState {
    data object Loading : SearchUIState()
    data class Success(val articles: List<Article>) : SearchUIState()
    data object Error : SearchUIState()
}