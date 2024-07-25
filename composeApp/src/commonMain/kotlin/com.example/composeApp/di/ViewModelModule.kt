package com.example.composeApp.di

import com.example.composeApp.presentation.main.MainViewModel
import com.example.composeApp.presentation.article.ArticleViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainViewModel(topLineUseCase = get()) }
    single { ArticleViewModel(articleUseCase = get()) }
}