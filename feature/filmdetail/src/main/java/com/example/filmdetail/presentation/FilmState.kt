package com.example.filmdetail.presentation

sealed interface FilmState {

	data object Initial : FilmState

	data class Content(
		val img: String,
		val title: String,
		val genres: List<String>,
		val year: String,
		val rating: String,
		val description: String,
	) : FilmState
}