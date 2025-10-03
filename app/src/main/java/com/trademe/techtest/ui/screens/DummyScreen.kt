package com.trademe.techtest.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.trademe.techtest.ui.theme.TextDark
import com.trademe.techtest.ui.theme.Typography

@Composable
fun DummyScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = title,
            style = Typography.labelMedium.copy(
                color = TextDark,
                fontWeight = FontWeight.Bold
            ),
        )
    }
}