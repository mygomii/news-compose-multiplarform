package com.example.composeApp.di

import com.example.composeApp.presentation.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainViewModel(articleUseCase = get()) }
}