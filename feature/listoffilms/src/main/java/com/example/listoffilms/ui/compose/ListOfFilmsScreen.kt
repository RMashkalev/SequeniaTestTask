package com.example.listoffilms.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.listoffilms.R
import com.example.listoffilms.presentation.ListOfFilmsState
import com.example.ui.AppBar
import com.example.ui.Loading
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ListOfFilmsScreen(
	uiStateFlow: StateFlow<ListOfFilmsState>,
	onLoading: () -> Unit,
	onTryAgain: () -> Unit,
	onFilmClick: () -> Unit,
	onGenreClick: () -> Unit,
) {

	val uiState by uiStateFlow.collectAsState()

	Scaffold(
		topBar = { AppBar(title = stringResource(id = R.string.list_of_films_label)) }
	) { paddingValues ->
		Box(modifier = Modifier.padding(paddingValues)) {
			when (val state = uiState) {
				is ListOfFilmsState.Initial -> onLoading()
				is ListOfFilmsState.Loading -> Loading()
				is ListOfFilmsState.Content ->
				is ListOfFilmsState.Error   -> Error()
			}
		}
	}
}
}