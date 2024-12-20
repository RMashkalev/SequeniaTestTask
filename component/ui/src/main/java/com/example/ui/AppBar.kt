package com.example.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
	Box(
		modifier = Modifier
			.height(56.dp)
			.fillMaxWidth()
			.background(Primary),
		contentAlignment = Alignment.CenterStart
	) {
		leftIcon?.let { icon ->
			IconButton(onClick = { leftIconAction?.invoke() }) {
				Icon(
					imageVector = icon,
					contentDescription = null,
					modifier = Modifier.size(24.dp),
					tint = ComponentAction
				)
			}
		}

		Text(
			modifier = Modifier
				.fillMaxWidth()
				.align(Alignment.Center)
				.padding(horizontal = 48.dp),
			text = title,
			textAlign = TextAlign.Center,
			maxLines = 1,
			color = ComponentText,
			style = Typography.bodyLarge,
			overflow = TextOverflow.Ellipsis
		)

	}
}