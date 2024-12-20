package com.example.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun Error(
	snackbarHostState: SnackbarHostState,
	onTryAgain: () -> Unit,
) {
	val context = LocalContext.current

	Box(modifier = Modifier.fillMaxSize())

	LaunchedEffect(key1 = Unit) {
		val result = snackbarHostState.showSnackbar(
			message = context.getString(R.string.loading_error),
			actionLabel = context.getString(R.string.loading_try_again),
			withDismissAction = false
		)

		if (result == SnackbarResult.ActionPerformed) {
			onTryAgain()
		}
	}
}