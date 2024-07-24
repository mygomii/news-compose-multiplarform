package com.example.composeApp.data.repositories

import com.example.composeApp.data.models.Article
import com.example.composeApp.data.models.Source

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
    suspend fun getTopLine(): List<Source>
}