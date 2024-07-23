package com.example.composeApp.data.datasources

import com.example.composeApp.data.models.Article

interface ArticleDataSource {
    suspend fun getArticles(): List<Article>
}