package com.example.composeApp.data.repositories

import com.example.composeApp.data.datasources.ArticleDataSource
import com.example.composeApp.data.models.Article
import com.example.composeApp.data.models.Source

class ArticleRepositoryImpl(
    private val articleDataSource: ArticleDataSource
) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return articleDataSource.getArticles()
    }

    override suspend fun getTopLine(): List<Source> {
        return articleDataSource.getTopLine()
    }
}