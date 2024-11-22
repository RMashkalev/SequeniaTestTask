package com.example.listoffilms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.listoffilms.presentation.ListOfFilmsViewModel
import com.example.listoffilms.ui.compose.ListOfFilmsScreen
import com.example.ui.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

fun getListOfFilmsScreen() = FragmentScreen { ListOfFilmsFragment.newInstance() }

class ListOfFilmsFragment : Fragment() {

	companion object {

		fun newInstance(): ListOfFilmsFragment = ListOfFilmsFragment()
	}

	private val viewModel: ListOfFilmsViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				Screen {
					ListOfFilmsScreen(
						uiStateFlow = viewModel.uiState,
						onLoading = viewModel::loading,
						onTryAgain = viewModel::tryAgain,
						onFilmClick = viewModel::filmClick,
						onGenreClick = viewModel::genreClick,
					)
				}
			}
		}
}