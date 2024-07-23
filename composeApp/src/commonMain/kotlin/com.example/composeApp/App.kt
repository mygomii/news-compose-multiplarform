package com.example.composeApp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.composeApp.di.commonModule
import com.example.composeApp.presentation.main.Main
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = {
        modules(modules = commonModule())
    }) {
        MaterialTheme {
            Main()
        }
    }
}
