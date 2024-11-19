package com.example.listoffilms.di

import com.example.listoffilms.presentation.ListOfFilmsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listOfFilmsModule = module {

	viewModel {
		ListOfFilmsViewModel(
			router = get()
		)
	}
}
