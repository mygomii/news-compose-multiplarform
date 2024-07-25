package com.example.composeApp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ContentView(
    canNavigateBack: Boolean,
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    contents: @Composable () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopBarView(
                title = "News",
                canNavigateBack = canNavigateBack,
                onBackClick = {
                    onBackClick()
                },
                onSearchClick = {
                    onSearchClick()
                }
            )
        }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
        ) {
            contents()
        }
    }
}