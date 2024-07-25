package com.example.composeApp.di

import com.mygomii.networkdModule.NetworkModule
import org.koin.dsl.module

private const val BASE_URL = "https://newsapi.org"
private const val TOKEN = "" // TODO; insert api token key

val networkModule = module {
    single {
        NetworkModule(baseUrl = BASE_URL, token = TOKEN).getHttpClient()
    }
}



