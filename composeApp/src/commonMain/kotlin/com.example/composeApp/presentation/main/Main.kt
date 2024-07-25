package com.example.composeApp.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeApp.extensions.stringToUrl
import com.example.composeApp.presentation.article.ArticleContent
import com.example.composeApp.presentation.components.EmptyView
import com.example.composeApp.presentation.events.MainUIState
import com.example.composeApp.presentation.home.Home
import com.example.composeApp.presentation.loading.LoadingView
import com.example.composeApp.presentation.webview.WebViewScreen
import org.koin.compose.getKoin

@Composable
fun Main(
    viewModel: MainViewModel = getKoin().get()
) {
    val mainUIState = viewModel.mainUIState.collectAsState().value

    when (mainUIState) {
        is MainUIState.Loading -> {
            LoadingView()
        }

        is MainUIState.Error -> {
            EmptyView()
        }

        is MainUIState.Success -> {
            Contents(viewModel)
        }
    }
}

@Composable
fun Contents(viewModel: MainViewModel, navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.value,
        modifier = Modifier
            .fillMaxSize()
    ) {
        composable(route = Screen.Main.value) {
            Home(viewModel, navController)
        }

        composable(
            route = Screen.WebView.value,
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) {
            val url = it.arguments?.getString("url")?.stringToUrl()
            println("###### url: $url")
            WebViewScreen(navController = navController, url = url ?: "")
        }

        composable(
            route = Screen.SearchContent.value,
            arguments = listOf(navArgument("q") { type = NavType.StringType })
        ) { entry ->
            val searchText = entry.arguments?.getString("q").toString()
            ArticleContent(navController = navController, searchText = searchText)
        }
    }
}

enum class Screen(val value: String) {
    Main("main"),
    WebView("webView/{url}"),
    SearchContent("searchContent/{q}")
}