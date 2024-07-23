package com.example.composeApp.data.repositories

import com.example.composeApp.data.models.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}