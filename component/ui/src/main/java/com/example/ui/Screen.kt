package com.example.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.theme.SequeniaTestTaskTheme

@Composable
fun Screen(
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit,
) {
	SequeniaTestTaskTheme {
		Surface(
			modifier = modifier
				.fillMaxSize()
				.systemBarsPadding()
				.imePadding(),
			color = MaterialTheme.colorScheme.background,
		) {
			Box(modifier = Modifier.fillMaxSize()) {
				content()
			}
		}
	}
}