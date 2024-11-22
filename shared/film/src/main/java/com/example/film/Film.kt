package com.example.film

import java.io.Serializable

data class Film(
	val id: Long,
	val localized_name: String,
	val name: String,
	val year: Int,
	val rating: Double? = null,
	val image_url: String? = null,
	val description: String? = null,
	val genres: List<String>,
) : Serializable