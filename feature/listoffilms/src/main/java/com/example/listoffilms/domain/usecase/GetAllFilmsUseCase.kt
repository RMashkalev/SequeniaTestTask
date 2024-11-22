package com.example.listoffilms.domain.usecase

import com.example.film.Film
import com.example.listoffilms.domain.repository.ListOfFilmsRepository

class GetAllFilmsUseCase(
	private val repository: ListOfFilmsRepository
) : suspend () -> List<Film> by repository::getAllFilms
