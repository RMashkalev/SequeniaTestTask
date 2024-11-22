package com.example.listoffilms.data.datasource

import com.example.listoffilms.data.model.FilmsModel
import retrofit2.http.GET

interface ListOfFilmsApi {

	@GET("films.json")
	suspend fun getAllFilms(): FilmsModel
}