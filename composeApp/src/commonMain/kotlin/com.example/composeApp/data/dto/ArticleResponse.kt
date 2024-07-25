package com.example.composeApp.data.dto

import com.example.composeApp.data.models.Article
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)