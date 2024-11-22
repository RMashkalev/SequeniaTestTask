package com.example.genres

import androidx.annotation.StringRes

enum class Genres(@StringRes val title: Int, @StringRes val lowerCaseTitle: Int) {
	BIOGRAPHY(R.string.biography, R.string.biography_lower_case),
	ACTION(R.string.action, R.string.action_lower_case),
	DETECTIVE(R.string.detective, R.string.detective_lower_case),
	DRAMA(R.string.drama, R.string.drama_lower_case),
	COMEDY(R.string.comedy, R.string.comedy_lower_case),
	CRIME(R.string.crime, R.string.crime_lower_case),
	MELODRAMA(R.string.melodrama, R.string.melodrama_lower_case),
	MUSICAL(R.string.musical, R.string.musical_lower_case),
	ADVENTURES(R.string.adventures, R.string.adventures_lower_case),
	THRILLER(R.string.thriller, R.string.thriller_lower_case),
	HORRORS(R.string.horrors, R.string.horrors_lower_case),
	FANTASY(R.string.fantasy, R.string.fantasy_lower_case);
}