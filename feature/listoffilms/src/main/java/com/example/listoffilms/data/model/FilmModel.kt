package com.example.listoffilms.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmModel(
	val id: Long,
	val localized_name: String,
	val name: String,
	val year: Int,
	val rating: Double? = null,
	val image_url: String? = null,
	val description: String? = null,
	val genres: List<String>,
)

@JsonClass(generateAdapter = true)
data class FilmsModel(
	val films: List<FilmModel>
)