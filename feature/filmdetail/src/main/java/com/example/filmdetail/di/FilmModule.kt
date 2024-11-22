package com.example.filmdetail.di

import com.example.filmdetail.presentation.FilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filmModule = module {

	viewModel {
		FilmViewModel(
			router = get()
		)
	}
}