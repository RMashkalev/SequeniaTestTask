package com.example.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
	title: String,
	leftIcon: ImageVector? = null,
	leftIconAction: (() -> Unit)? = null
) {
	TopAppBar(
		title = {
			Text(
				modifier = Modifier.fillMaxSize(),
				text = title
			)
		},
		modifier = Modifier.fillMaxSize(),
		navigationIcon = {
			leftIcon?.let { icon ->
				IconButton(onClick = { leftIconAction?.invoke() }) {
					Icon(
						imageVector = icon,
						contentDescription = null,
						modifier = Modifier.size(24.dp)
					)
				}
			}
		}
	)
}