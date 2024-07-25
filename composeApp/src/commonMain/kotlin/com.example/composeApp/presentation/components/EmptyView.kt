package com.example.composeApp.presentation.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun EmptyView() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        text = "내용이 없어요",
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        color = Color.Gray,
        textAlign = TextAlign.Center
    )
}