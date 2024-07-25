package com.example.composeApp.data.datasources

import com.example.composeApp.data.models.Article
import com.example.composeApp.data.models.Source

interface ArticleDataSource {
    suspend fun getArticles(searchText: String): List<Article>
    suspend fun getTopLine(): List<Source>
}