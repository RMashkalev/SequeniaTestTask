package com.example.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.theme.ComponentAction
import com.example.theme.ComponentText
import com.example.theme.Primary
import com.example.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
	title: String,
	leftIcon: ImageVector? = null,
	leftIconAction: (() -> Unit)? = null
) {
	TopAppBar(
		title = {
			Box(
				modifier = Modifier.fillMaxSize(),
				contentAlignment = Alignment.Center
			) {
				Text(
					text = title,
					textAlign = TextAlign.Center,
					style = Typography.bodyLarge
				)
			}
		},
		modifier = Modifier
			.height(56.dp),
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
		},
		colors = TopAppBarColors(
			containerColor = Primary,
			scrolledContainerColor = Primary,
			navigationIconContentColor = ComponentAction,
			titleContentColor = ComponentText,
			actionIconContentColor = ComponentAction
		)
	)
}