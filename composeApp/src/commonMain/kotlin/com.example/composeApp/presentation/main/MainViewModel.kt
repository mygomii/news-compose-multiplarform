package com.example.composeApp.presentation.main

import com.example.composeApp.data.models.Article
import com.example.composeApp.domain.usecases.GetArticleUseCase
import com.example.composeApp.presentation.base.BaseViewModel
import com.example.composeApp.presentation.events.UiState
import com.example.composeApp.presentation.events.UiState.Loading
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val articleUseCase: GetArticleUseCase
) : BaseViewModel() {
    private val _uiState = MutableStateFlow<UiState>(Loading)
    val uiState: StateFlow<UiState> = _uiState

    private val _article = MutableStateFlow<List<Article>>(emptyList())
    val article: StateFlow<List<Article>> get() = _article

    init {
        viewModelScope.launch {
            _uiState.value = UiState.Success(articleUseCase.invoke())
        }
    }

}