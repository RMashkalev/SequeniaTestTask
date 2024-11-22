package com.example.filmdetail.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.film.Film
import com.example.filmdetail.R
import com.example.ui.AppBar

@Composable
fun FilmScreen(
	film: Film,
	onNavigateBack: () -> Unit,
) {
	Scaffold(
		topBar = {
			AppBar(
				title = film.name,
				leftIcon = ImageVector.vectorResource(id = R.drawable.arrow_left_25),
				leftIconAction = onNavigateBack
			)
		},
	) { paddingValues ->
		Box(modifier = Modifier.padding(paddingValues)) {
			FilmContent(
				film = film
			)
		}
	}
}