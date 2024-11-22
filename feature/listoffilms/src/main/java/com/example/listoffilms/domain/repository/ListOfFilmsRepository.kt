package com.example.listoffilms.domain.repository

import com.example.film.Film

interface ListOfFilmsRepository {

	suspend fun getAllFilms(): List<Film>

	suspend fun getFilteredFilms(genre: String): List<Film>
}