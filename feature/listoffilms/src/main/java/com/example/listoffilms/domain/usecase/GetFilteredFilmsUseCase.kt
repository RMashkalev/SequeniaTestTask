package com.example.listoffilms.domain.usecase

import com.example.film.Film
import com.example.listoffilms.domain.repository.ListOfFilmsRepository

class GetFilteredFilmsUseCase(
	repository: ListOfFilmsRepository
) : suspend (String) -> List<Film> by repository::getFilteredFilms