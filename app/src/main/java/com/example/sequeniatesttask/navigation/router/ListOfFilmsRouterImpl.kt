package com.example.sequeniatesttask.navigation.router

import com.example.film.Film
import com.example.filmdetail.ui.getFilmScreen
import com.example.listoffilms.presentation.ListOfFilmsRouter
import com.github.terrakok.cicerone.Router

class ListOfFilmsRouterImpl(private val router: Router) : ListOfFilmsRouter {

	override fun navigateToFilm(film: Film) {
		router.navigateTo(getFilmScreen(film = film))
	}
}