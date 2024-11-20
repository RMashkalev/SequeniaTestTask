package com.example.listoffilms.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListOfFilmsViewModel(
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
			delay(10000)
			_uiState.value = ListOfFilmsState.Error
		}
	}

	fun tryAgain() {
		loading()
	}

	fun genreClick() {

	}

	fun filmClick() {

	}
}