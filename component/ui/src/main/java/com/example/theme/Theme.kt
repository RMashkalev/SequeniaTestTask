package com.example.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
	primary = Primary,
	secondary = Secondary,
	background = Background
)

@Composable
fun SequeniaTestTaskTheme(
	content: @Composable () -> Unit
) {
	val colorScheme = LightColorScheme

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}