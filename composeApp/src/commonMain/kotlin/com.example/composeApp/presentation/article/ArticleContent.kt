package com.example.composeApp.presentation.article

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.composeApp.data.models.Article
import com.example.composeApp.extensions.urlToString
import com.example.composeApp.presentation.components.ContentView
import com.example.composeApp.presentation.components.EmptyView
import com.example.composeApp.presentation.events.MainUIState
import com.example.composeApp.presentation.events.SearchUIState
import org.koin.compose.getKoin

@Composable
fun ArticleContent(
    articleViewModel: ArticleViewModel = getKoin().get(),
    navController: NavHostController,
    searchText: String
) {
    articleViewModel.initializeView(searchText)
    val searchUIState = articleViewModel.searchUIState.value

    when (searchUIState) {
        is SearchUIState.Loading -> {
            Text(text = "Loading....")
        }

        is SearchUIState.Error -> {
            EmptyView()
        }

        is SearchUIState.Success -> {
            Contents(viewModel = articleViewModel, navController = navController)
        }
    }

}

@Composable
fun Contents(
    viewModel: ArticleViewModel,
    navController: NavHostController
) {
    val articles = viewModel.articles.value

    ContentView(
        canNavigateBack = true,
        onBackClick = {
            navController.popBackStack()
        },
        contents = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentPadding = PaddingValues(5.dp)
            ) {
                items(articles.size) { index ->
                    item(
                        article = articles[index],
                        onItemClick = {
                            navController.navigate("webView/${articles[index].url.urlToString()}")
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun item(article: Article, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(2.dp, SolidColor(Color.LightGray), RoundedCornerShape(20.dp))
            .padding(10.dp)
            .clickable {
                onItemClick()
            }) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(),

            model = article.urlToImage,
            contentDescription = "${article.author}"
        )

        Text(
            text = article.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal,
            color = Color.Black

        )
        Text(
            text = article.description ?: "",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Gray,
            fontStyle = FontStyle.Normal
        )
        Text(
            text = article.content,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            color = Color.LightGray,
            fontStyle = FontStyle.Normal
        )
    }


}