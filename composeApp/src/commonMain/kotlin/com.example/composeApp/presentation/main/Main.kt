package com.example.composeApp.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeApp.presentation.events.UiState
import org.koin.compose.getKoin

@Composable
fun Main(viewModel: MainViewModel = getKoin().get()) {
    val uiState = viewModel.uiState.collectAsState().value

    when (uiState) {
        is UiState.Loading, UiState.Error -> {
            Text(text = "Loading....")
        }

        is UiState.Success -> {
            val articles = uiState.articles

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentPadding = PaddingValues(5.dp)
            ) {
                items(articles.size) { index ->
                    Text(
                        color = Color.White,
                        text = articles[index].title
                    )
                }
            }
        }
    }
}
