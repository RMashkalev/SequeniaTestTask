package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

const val COLOR_LACK_PICTURE = 0xFFEFEFEF

@Composable
fun ImageFilm(
	modifier: Modifier = Modifier,
	imgUrl: String?,
	size: Dp,
) {
	if (imgUrl != null) {
		var isError by remember { mutableStateOf(false) }

		if (!isError) {
			Image(
				painter = rememberAsyncImagePainter(
					model = ImageRequest.Builder(LocalContext.current)
						.data(imgUrl)
						.listener(
							onError = { _, _ ->
								isError = true
							},
							onSuccess = { _, _ ->
								isError = false
							}
						)
						.build()
				),
				contentDescription = null,
				modifier = modifier
					.aspectRatio(0.7F)
					.size(size = size)
					.clip(RoundedCornerShape(size = 4.dp)),
				contentScale = ContentScale.Crop
			)
		}

		if (isError) {
			PlaceHolder(modifier = modifier)
		}
	} else {
		PlaceHolder(modifier = modifier)
	}
}

@Composable
private fun PlaceHolder(
	modifier: Modifier = Modifier,
) {
	Box(
		modifier = modifier
			.aspectRatio(0.7F)
			.background(Color(COLOR_LACK_PICTURE))
			.clip(
				RoundedCornerShape(size = 4.dp)
			),
		contentAlignment = Alignment.Center
	) {
		Image(
			imageVector = ImageVector.vectorResource(id = R.drawable.perm_media),
			contentDescription = null,
		)
	}
}