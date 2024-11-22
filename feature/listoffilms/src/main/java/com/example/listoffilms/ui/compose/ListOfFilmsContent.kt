package com.example.listoffilms.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.film.Film
import com.example.genres.Genres
import com.example.listoffilms.R
import com.example.listoffilms.presentation.ListOfFilmsState
import com.example.theme.Background
import com.example.theme.Secondary
import com.example.theme.Typography
import com.example.ui.ImageFilm

const val FILMS_IN_ROW = 2


@Composable
fun ListOfFilmsContent(
	uiState: ListOfFilmsState.Content,
	onGenreClick: (Genres) -> Unit,
	onFilmClick: (Film) -> Unit,
) {

	Box {
		Column {
			LazyColumn {
				genresBlock(
					genre = uiState.genre,
					onGenreClick = onGenreClick
				)

				filmsBlock(
					films = uiState.films.chunked(FILMS_IN_ROW),
					onFilmClick = onFilmClick
				)
			}
		}
	}

}

fun LazyListScope.genresBlock(
	genre: String?,
	onGenreClick: (Genres) -> Unit
) {
	item {
		Spacer(modifier = Modifier.padding(top = 8.dp))
	}

	item {
		Box(
			modifier = Modifier
				.padding(horizontal = 16.dp, vertical = 8.dp)
		) {
			Text(
				text = stringResource(id = R.string.genres_title),
				style = Typography.titleLarge
			)
		}
	}

	items(Genres.entries) {
		ClickableGenre(
			genre = it,
			checked = stringResource(id = it.title) == genre,
			onGenreClick = onGenreClick
		)
	}

	item {
		Spacer(modifier = Modifier.padding(top = 16.dp))
	}
}

@Composable
fun ClickableGenre(
	genre: Genres,
	checked: Boolean,
	onGenreClick: (Genres) -> Unit,
) {
	val backgroundColor = if (checked) Secondary else Background

	Box(
		modifier = Modifier
			.background(backgroundColor)
			.clickable { onGenreClick(genre) },
	) {
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp, vertical = 10.dp),
			text = stringResource(id = genre.title),
			style = Typography.bodyLarge,
		)
	}
}

fun LazyListScope.filmsBlock(
	films: List<List<Film>>,
	onFilmClick: (Film) -> Unit
) {
	item {
		Box(
			modifier = Modifier
				.padding(horizontal = 16.dp, vertical = 8.dp)
		) {
			Text(
				text = stringResource(id = R.string.list_of_films_label),
				style = Typography.titleLarge
			)
		}
	}

	item {
		Spacer(modifier = Modifier.padding(top = 8.dp))
	}

	items(films) { filmsRow ->
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 8.dp),
			horizontalArrangement = Arrangement.SpaceAround
		) {
			filmsRow.forEach {
				ClickableFilm(
					modifier = Modifier.weight(1.0f),
					film = it,
					onFilmClick = onFilmClick,
				)
			}

			if (filmsRow.size < FILMS_IN_ROW) {
				for (i in filmsRow.size until FILMS_IN_ROW) {
					Box(modifier = Modifier.weight(1.0f))
				}
			}
		}

		Spacer(modifier = Modifier.padding(top = 16.dp))
	}
}

@Composable
fun ClickableFilm(
	modifier: Modifier,
	film: Film,
	onFilmClick: (Film) -> Unit
) {
	Column(
		modifier = modifier
			.padding(horizontal = 8.dp)
			.clickable { onFilmClick(film) }
	) {
		ImageFilm(
			imgUrl = film.image_url,
			size = 160.dp,
		)

		Spacer(modifier = Modifier.padding(top = 8.dp))

		Text(
			text = film.localized_name,
			style = Typography.titleSmall,
			maxLines = 2,
		)

		Spacer(modifier = Modifier.padding(top = 20.dp))
	}
}




