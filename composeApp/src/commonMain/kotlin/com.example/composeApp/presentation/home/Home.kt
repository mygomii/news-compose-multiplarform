package com.example.composeApp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.composeApp.presentation.components.ContentView
import com.example.composeApp.presentation.components.SearchView
import com.example.composeApp.presentation.headline.Headline
import com.example.composeApp.presentation.main.MainViewModel

@Composable
fun Home(viewModel: MainViewModel, navController: NavHostController) {
    var isClicked by remember { mutableStateOf(false) }

    ContentView(
        canNavigateBack = false,
        contents = {
            Column {
                if (isClicked) {
                    SearchView {
                        isClicked = false
                        navController.navigate("searchContent/${it}")
                    }
                }

                Headline(
                    navController = navController,
                    viewModel = viewModel
                )
            }

        },
        onSearchClick = {
            isClicked = !isClicked
        })
}
