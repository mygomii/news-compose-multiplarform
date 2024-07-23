package com.example.composeApp.di

import com.example.composeApp.domain.usecases.GetArticleUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetArticleUseCase(repository = get()) }
}