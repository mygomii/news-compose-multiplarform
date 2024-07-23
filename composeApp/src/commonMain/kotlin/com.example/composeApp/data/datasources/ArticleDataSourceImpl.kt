package com.example.composeApp.data.datasources

import com.example.composeApp.data.dto.ArticleResponse
import com.example.composeApp.data.models.Article
import com.example.composeApp.extensions.get
import io.ktor.client.HttpClient

class ArticleDataSourceImpl(
    private val client: HttpClient
) : ArticleDataSource {
    override suspend fun getArticles(): List<Article> {
        return client.get<ArticleResponse>(
            route = "v2/everything",
            queryPair = listOf(Pair("q", "bitcoin"))
        ).articles
    }
}