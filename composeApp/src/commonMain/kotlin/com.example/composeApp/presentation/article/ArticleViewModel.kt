package com.example.composeApp.presentation.article

import com.example.composeApp.data.models.Article
import com.example.composeApp.domain.usecases.GetArticleUseCase
import com.example.composeApp.presentation.base.BaseViewModel
import com.example.composeApp.presentation.events.SearchUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val articleUseCase: GetArticleUseCase
) : BaseViewModel() {
    private val _searchUIState = MutableStateFlow<SearchUIState>(SearchUIState.Loading)
    val searchUIState: StateFlow<SearchUIState> = _searchUIState

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    var articles: StateFlow<List<Article>> = _articles

    private val _searchText = MutableStateFlow("")
    var searchText = _searchText.asStateFlow()

    fun initializeView(searchText: String) {
        viewModelScope.launch {
            _searchText.value = searchText
            val articles = articleUseCase.invoke(searchText)

            if (articles.isEmpty()) {
                _searchUIState.value = SearchUIState.Error
                return@launch
            }

            _articles.value = articles
            _searchUIState.value = SearchUIState.Success(articles)

        }

    }
}
