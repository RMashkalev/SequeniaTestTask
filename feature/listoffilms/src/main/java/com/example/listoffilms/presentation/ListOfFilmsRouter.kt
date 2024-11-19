package com.example.listoffilms.presentation

import com.example.film.Film

interface ListOfFilmsRouter {

	fun navigateToFilm(film: Film)
}