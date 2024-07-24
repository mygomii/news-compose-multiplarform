package com.example.composeApp.presentation.headline

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.composeApp.presentation.main.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Headline(navController: NavHostController, viewModel: MainViewModel) {
    val sources = viewModel.sources.value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(5.dp)
    ) {
        items(sources.size) { index ->
            HeadlineItem(
                title = sources[index].name,
                description = sources[index].description ?: "",
                onItemClick = {
                    viewModel.setSelectedNews(index)
                    navController.navigate("webview/${index}")
                }
            )
        }
    }

}


@Composable
fun HeadlineItem(title: String, description: String, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(2.dp, SolidColor(Color.LightGray), RoundedCornerShape(20.dp))
            .padding(10.dp)
            .clickable {
                onItemClick()
            }

    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal

        )
        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = Color.Gray,
            fontStyle = FontStyle.Normal
        )

    }
}



