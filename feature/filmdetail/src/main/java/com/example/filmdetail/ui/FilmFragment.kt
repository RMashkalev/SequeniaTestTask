package com.example.filmdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.film.Film
import com.example.filmdetail.presentation.FilmViewModel
import com.example.filmdetail.ui.compose.FilmScreen
import com.example.ui.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

fun getFilmScreen(film: Film) = FragmentScreen { FilmFragment.newInstance(film) }

class FilmFragment : Fragment() {

	companion object {

		private const val FILM = "FILM"

		fun newInstance(film: Film): FilmFragment = FilmFragment().apply {
			arguments = bundleOf(
				FILM to film
			)
		}
	}

	private val viewModel: FilmViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				Screen {
					FilmScreen(
						film = arguments?.get(FILM) as Film,
						onNavigateBack = viewModel::navigateBack,
					)
				}
			}
		}
}