package com.example.composeApp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.composeApp.di.commonModule
import com.example.composeApp.presentation.main.Main
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(modules = commonModule())
    }) {
        MaterialTheme {
            Main()
        }
    }
}
