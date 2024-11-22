package com.example.listoffilms.data.mapper

import com.example.film.Film
import com.example.listoffilms.data.model.FilmModel

class FilmsMapper {

	operator fun invoke(model: FilmModel): Film = Film(
		id = model.id,
		localized_name = model.localized_name,
		name = model.name,
		year = model.year,
		rating = model.rating,
		image_url = model.image_url,
		description = model.description,
		genres = model.genres
	)
}
