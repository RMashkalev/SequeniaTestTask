package com.example.listoffilms.presentation

import com.example.film.Film

interface ListOfFilmsState {

	data object Initial : ListOfFilmsState

	data object Loading : ListOfFilmsState

	data object Error : ListOfFilmsState

	data class Content(
		val films: List<Film>,
		val genre: String?,
	) : ListOfFilmsState
}