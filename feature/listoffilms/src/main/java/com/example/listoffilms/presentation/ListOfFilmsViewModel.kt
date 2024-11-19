package com.example.listoffilms.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListOfFilmsViewModel(
	router: ListOfFilmsRouter
) : ViewModel() {

	private val _uiState = MutableStateFlow<ListOfFilmsState>(ListOfFilmsState.Initial)
	val uiState: StateFlow<ListOfFilmsState> = _uiState


}