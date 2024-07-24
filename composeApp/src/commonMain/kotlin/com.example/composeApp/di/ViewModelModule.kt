package com.example.composeApp.di

import com.example.composeApp.presentation.main.MainViewModel
import com.example.composeApp.presentation.search.SearchViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        MainViewModel(
            articleUseCase = get(),
            topLineUseCase = get()
        )
    }

    single {
        SearchViewModel()
    }
}