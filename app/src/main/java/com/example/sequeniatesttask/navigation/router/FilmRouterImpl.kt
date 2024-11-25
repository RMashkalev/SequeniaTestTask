package com.example.sequeniatesttask.navigation.router

import com.example.filmdetail.presentation.FilmRouter
import com.example.listoffilms.ui.getListOfFilmsScreen
import com.github.terrakok.cicerone.Router

class FilmRouterImpl(private val router: Router) : FilmRouter {

	override fun navigateBack() {
		router.backTo(getListOfFilmsScreen())
	}
}