package com.example.composeApp.data.repositories

import com.example.composeApp.data.datasources.ArticleDataSource
import com.example.composeApp.data.models.Article
import com.example.composeApp.data.models.Source

class ArticleRepositoryImpl(
    private val articleDataSource: ArticleDataSource
) : ArticleRepository {
    override suspend fun getArticles(searchText: String): List<Article> {
        return articleDataSource.getArticles(searchText)
    }

    override suspend fun getTopLine(): List<Source> {
        return articleDataSource.getTopLine()
    }
}