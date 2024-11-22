package com.example.listoffilms.data.repository

import com.example.film.Film
import com.example.listoffilms.data.datasource.ListOfFilmsApi
import com.example.listoffilms.data.mapper.FilmsMapper
import com.example.listoffilms.domain.repository.ListOfFilmsRepository

class ListOfFilmsRepositoryImpl(
	private val dataSource: ListOfFilmsApi,
	private val mapper: FilmsMapper
) : ListOfFilmsRepository {

	override suspend fun getAllFilms(): List<Film> {
		return dataSource.getAllFilms().films.map { mapper(it) }.sortedBy { it.localized_name }
	}

	override suspend fun getFilteredFilms(genre: String): List<Film> {
		return dataSource.getAllFilms().films.map { mapper(it) }.sortedBy { it.localized_name }.filter { it.genres.contains(genre) }
	}

}