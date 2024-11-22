package com.example.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.theme.ComponentActionText
import com.example.theme.ComponentBackground
import com.example.theme.ComponentText
import com.example.theme.Typography

@Composable
fun CustomSnackbar(
	modifier: Modifier = Modifier,
	onAction: () -> Unit,
) {
	Surface(
		color = ComponentBackground,
		shadowElevation = 6.dp,
		modifier = modifier
			.padding(horizontal = 16.dp, vertical = 8.dp)
			.fillMaxWidth()
			.height(70.dp),
		shape = RoundedCornerShape(size = 4.dp),
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Spacer(modifier = Modifier.padding(start = 24.dp))

			Text(
				modifier = Modifier.weight(1f),
				text = stringResource(id = R.string.loading_error),
				color = ComponentText,
				textAlign = TextAlign.Start,
				style = Typography.bodyMedium,
				overflow = TextOverflow.Ellipsis
			)

			Text(
				modifier = Modifier
					.clickable { onAction() }
					.weight(1.0f),
				text = stringResource(id = R.string.loading_try_again),
				color = ComponentActionText,
				textAlign = TextAlign.End,
				style = Typography.bodyMedium,
				overflow = TextOverflow.Ellipsis
			)

			Spacer(modifier = Modifier.padding(start = 24.dp))
		}

	}
}