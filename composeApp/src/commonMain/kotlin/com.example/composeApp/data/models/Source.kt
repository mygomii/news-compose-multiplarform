package com.example.composeApp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Source(
    val id: String? = null,
    val name: String,
)