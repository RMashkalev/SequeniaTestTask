package com.example.filmdetail.presentation

import androidx.lifecycle.ViewModel

class FilmViewModel(
	private val router: FilmRouter,
) : ViewModel() {

	fun navigateBack() {
		router.navigateBack()
	}
}