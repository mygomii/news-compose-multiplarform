package com.example.composeApp.presentation.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composeApp.presentation.components.ContentView
import com.example.composeApp.presentation.headline.Headline
import com.example.composeApp.presentation.main.MainViewModel


@Composable
fun Home(viewModel: MainViewModel, navController: NavHostController) {
    ContentView(
        canNavigateBack = false,
        contents = {
            Headline(
                navController = navController,
                viewModel = viewModel
            )
        })
}
