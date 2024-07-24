package com.example.composeApp.domain.usecases

import com.example.composeApp.data.models.Source
import com.example.composeApp.data.repositories.ArticleRepository

class GetTopLineUseCase(
    private val repository: ArticleRepository
) {
    suspend fun invoke(): List<Source> = repository.getTopLine()
}