package com.example.sequeniatesttask.presentation

import androidx.lifecycle.ViewModel

class MainViewModel(private val router: MainRouter) : ViewModel() {

	fun setStartScreen() {
		router.navigateToListOfFilms()
	}
}