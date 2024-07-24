package com.example.composeApp.data.datasources

import com.example.composeApp.data.dto.ArticleResponse
import com.example.composeApp.data.dto.TopLineResponse
import com.example.composeApp.data.models.Article
import com.example.composeApp.data.models.Source
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

    override suspend fun getTopLine(): List<Source> {
        return client.get<TopLineResponse>(
            route = "v2/top-headlines/sources",
        ).sources
    }
}