package com.example.sequeniatesttask.di

import com.example.sequeniatesttask.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
	viewModel {
		MainViewModel(router = get())
	}
}