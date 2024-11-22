package com.example.listoffilms.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.genres.Genres
import com.example.listoffilms.domain.usecase.GetAllFilmsUseCase
import com.example.listoffilms.domain.usecase.GetFiltredFilmsUseCase
import com.example.utils.usecase.GetStringByIdUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListOfFilmsViewModel(
	private val getAllFilmsUseCase: GetAllFilmsUseCase,
	private val getFiltredFilmsUseCase: GetFiltredFilmsUseCase,
	private val getStringByIdUseCase: GetStringByIdUseCase,
	router: ListOfFilmsRouter
) : ViewModel() {

	private val _uiState = MutableStateFlow<ListOfFilmsState>(ListOfFilmsState.Initial)
	val uiState: StateFlow<ListOfFilmsState> = _uiState

	private val errorHandler = CoroutineExceptionHandler { _, _ ->
		_uiState.value = ListOfFilmsState.Error
	}

	fun loading() {
		_uiState.value = ListOfFilmsState.Loading
		viewModelScope.launch(errorHandler) {
			val films = getAllFilmsUseCase()
			_uiState.value = ListOfFilmsState.Content(
				films = films,
				genre = null,
			)
		}
	}

	fun tryAgain() {
		loading()
	}

	fun genreClick(genre: Genres) {
		val currentState = uiState.value
		if (currentState !is ListOfFilmsState.Content)
			return

		val genreTitle = getStringByIdUseCase(genre.title)
		val genreLowerCaseTitle = getStringByIdUseCase(genre.lowerCaseTitle)

		viewModelScope.launch(errorHandler) {
			val newGenre = if (currentState.genre == genreTitle) null else genreTitle
			val films = if (newGenre != null) getFiltredFilmsUseCase(genreLowerCaseTitle) else getAllFilmsUseCase()
			_uiState.value = currentState.copy(
				films = films,
				genre = newGenre
			)
		}
	}

	fun filmClick() {

	}
}