package com.example.composeApp.domain.usecases

import com.example.composeApp.data.models.Article
import com.example.composeApp.data.repositories.ArticleRepository

class GetArticleUseCase(
    private val repository: ArticleRepository
) {
    suspend fun invoke(searchText: String): List<Article> = repository.getArticles(searchText)
}