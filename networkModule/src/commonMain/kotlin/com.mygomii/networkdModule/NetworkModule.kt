package com.mygomii.networkdModule

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkModule(
    private val baseUrl: String,
    private val token: String? = null
) {
    fun getHttpClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        encodeDefaults = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("########## $message")
                    }
                }
                level = LogLevel.ALL
            }

            defaultRequest {
                url(baseUrl)
                header("Content-Type", "application/json")
                header("Accept", "application/json")
                if (!token.isNullOrEmpty()) {
                    header("Authorization", "Bearer $token")
                }

            }
        }
    }
}