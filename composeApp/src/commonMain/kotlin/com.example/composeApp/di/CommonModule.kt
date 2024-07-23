package com.example.composeApp.di

fun commonModule() = listOf(
    networkModule,
    dataSourceModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)
