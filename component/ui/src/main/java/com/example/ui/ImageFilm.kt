package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

const val COLOR_LACK_PICTURE = 0xFF4B4B4B

@Composable
fun ImageFilm(
	modifier: Modifier = Modifier,
	imgUrl: String?,
	size: Dp,
) {
	if (imgUrl != null) {
		Image(
			painter = rememberAsyncImagePainter(imgUrl),
			contentDescription = null,
			modifier = modifier
				.aspectRatio(0.7F)
				.size(size = size)
				.clip(RoundedCornerShape(size = 4.dp)),
			contentScale = ContentScale.Crop
		)
	} else {

		Box(
			modifier = modifier
				.aspectRatio(0.7F)
				.background(Color(COLOR_LACK_PICTURE))
				.clip(
					RoundedCornerShape(
						topStart = 4.dp,
						topEnd = 4.dp,
						bottomStart = 4.dp,
						bottomEnd = 4.dp
					)
				),
		) {
		}
	}
}