package com.example.composeApp.extensions

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.timeout
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path

suspend inline fun <reified T> HttpClient.get(
    route: String,
    queryPair: List<Pair<String, String>>? = null,
): T = this.get {
    url {
        path(route)
        queryPair?.forEach { pair ->
            parameters.append(pair.first, pair.second)
        }
    }
}.body() as T


suspend inline fun <reified T, reified BODY> HttpClient.post(
    route: String,
    queryPair: List<Pair<String, String>>? = null,
    body: BODY
): T = this.post {
    url {
        protocol = URLProtocol.HTTPS
        path(route)
        queryPair?.forEach { pair ->
            parameters.append(pair.first, pair.second)
        }
        setBody(body)
    }
    timeout { requestTimeoutMillis = Long.MAX_VALUE }
}.body() as T