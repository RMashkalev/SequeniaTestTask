package com.example.filmdetail.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.film.Film
import com.example.filmdetail.R
import com.example.theme.Primary
import com.example.theme.Typography
import com.example.ui.ImageFilm
import java.util.Locale

@Composable
fun FilmContent(
	film: Film,
) {
	val scrollState = rememberScrollState()

	Column(
		modifier = Modifier
			.padding(start = 16.dp, end = 16.dp)
			.verticalScroll(scrollState)
	) {
		Spacer(modifier = Modifier.padding(top = 24.dp))

		Row {
			Box(modifier = Modifier.weight(0.3f))

			ImageFilm(
				imgUrl = film.image_url,
				size = 132.dp,
				modifier = Modifier.weight(0.4f)
			)

			Box(modifier = Modifier.weight(0.3f))
		}

		Spacer(modifier = Modifier.padding(top = 24.dp))

		Text(
			text = film.localized_name,
			style = Typography.titleLarge
		)

		Spacer(modifier = Modifier.padding(top = 8.dp))

		GenresAndYear(
			genres = film.genres,
			year = film.year
		)

		film.rating?.let {
			Spacer(modifier = Modifier.padding(top = 10.dp))

			Rating(rating = requireNotNull(film.rating))
		}

		film.description?.let {
			Spacer(modifier = Modifier.padding(top = 14.dp))

			Text(
				text = film.description.toString(),
				style = Typography.bodySmall
			)
		}

		Spacer(modifier = Modifier.padding(top = 15.dp))
	}

}

@Composable
private fun GenresAndYear(
	genres: List<String>,
	year: Int
) {
	if (genres.isEmpty()) {
		Text(
			text = "$year ${stringResource(id = R.string.year)}",
			style = Typography.bodyMedium
		)
	} else {
		Text(
			text = "${genres.joinToString(separator = ", ")}, $year ${stringResource(id = R.string.year)}",
			style = Typography.bodyMedium
		)
	}

}

@Composable
private fun Rating(
	rating: Double,
) {
	Row(
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = String.format(Locale.US, "%.1f ", rating),
			style = Typography.titleLarge,
			color = Primary,
		)
		Text(
			modifier = Modifier
				.align(Alignment.CenterVertically)
				.offset(y = 3.dp),
			text = stringResource(id = R.string.kinopoisk),
			style = Typography.titleSmall,
			color = Primary
		)
	}
}