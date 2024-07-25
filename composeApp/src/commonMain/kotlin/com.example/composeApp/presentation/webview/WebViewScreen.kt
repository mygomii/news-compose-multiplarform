package com.example.composeApp.presentation.webview

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.composeApp.presentation.components.ContentView
import com.multiplatform.webview.web.LoadingState
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState

@Composable
fun WebViewScreen(navController: NavHostController, url: String) {
    val state = rememberWebViewState(url)
    val navigator = rememberWebViewNavigator()

    ContentView(
        true,
        onBackClick = {
            println("######## canGoBack : ${navigator.canGoBack}")
            if (navigator.canGoBack) {
                navigator.navigateBack()
            }
            if (!navigator.canGoBack) {
                navController.popBackStack()
            }
        },
        contents = {
            WebView(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                state = state
            )

            val loadingState = state.loadingState
            if (loadingState is LoadingState.Loading) {
                LinearProgressIndicator(
                    progress = loadingState.progress,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    )

}