package com.example.composeApp.data.dto

import com.example.composeApp.data.models.Source
import kotlinx.serialization.Serializable

@Serializable
data class TopLineResponse(
    val status: String,
    val sources: List<Source>
)