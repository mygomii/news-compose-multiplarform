package com.example.composeApp.data.repositories

import com.example.composeApp.data.datasources.ArticleDataSource
import com.example.composeApp.data.models.Article

class ArticleRepositoryImpl(
    private val articleDataSource: ArticleDataSource
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return articleDataSource.getArticles()
    }
}