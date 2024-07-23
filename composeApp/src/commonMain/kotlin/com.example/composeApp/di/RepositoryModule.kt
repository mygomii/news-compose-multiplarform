package com.example.composeApp.di

import com.example.composeApp.data.repositories.ArticleRepository
import com.example.composeApp.data.repositories.ArticleRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ArticleRepository> { ArticleRepositoryImpl(articleDataSource = get()) }
}