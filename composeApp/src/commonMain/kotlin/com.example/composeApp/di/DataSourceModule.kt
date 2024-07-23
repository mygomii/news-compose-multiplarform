package com.example.composeApp.di

import com.example.composeApp.data.datasources.ArticleDataSource
import com.example.composeApp.data.datasources.ArticleDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<ArticleDataSource> {
        ArticleDataSourceImpl(client = get())
    }
}