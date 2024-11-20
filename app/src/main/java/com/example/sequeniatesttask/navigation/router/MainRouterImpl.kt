package com.example.sequeniatesttask.navigation.router

import com.example.listoffilms.ui.getFilmScreen
import com.example.sequeniatesttask.presentation.MainRouter
import com.github.terrakok.cicerone.Router

class MainRouterImpl(private val router: Router) : MainRouter {

	override fun navigateToListOfFilms() {
		router.newRootScreen(getFilmScreen())
	}
}