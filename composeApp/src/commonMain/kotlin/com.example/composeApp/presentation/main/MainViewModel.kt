package com.example.composeApp.presentation.main

import com.example.composeApp.data.models.Source
import com.example.composeApp.domain.usecases.GetTopLineUseCase
import com.example.composeApp.presentation.base.BaseViewModel
import com.example.composeApp.presentation.events.MainUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val topLineUseCase: GetTopLineUseCase
) : BaseViewModel() {
    private val _mainUIState = MutableStateFlow<MainUIState>(MainUIState.Loading)
    val mainUIState: StateFlow<MainUIState> = _mainUIState

    private val _sources = MutableStateFlow<List<Source>>(emptyList())
    var sources: StateFlow<List<Source>> = _sources

    init {
        viewModelScope.launch {
            _sources.value = topLineUseCase.invoke()
            _mainUIState.value = MainUIState.Success(topLineUseCase.invoke())
        }
    }
}