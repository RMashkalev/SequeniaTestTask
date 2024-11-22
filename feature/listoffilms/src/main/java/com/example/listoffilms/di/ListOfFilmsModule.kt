package com.example.listoffilms.di

import com.example.listoffilms.data.datasource.ListOfFilmsApi
import com.example.listoffilms.data.mapper.FilmsMapper
import com.example.listoffilms.data.repository.ListOfFilmsRepositoryImpl
import com.example.listoffilms.domain.repository.ListOfFilmsRepository
import com.example.listoffilms.domain.usecase.GetAllFilmsUseCase
import com.example.listoffilms.domain.usecase.GetFilteredFilmsUseCase
import com.example.listoffilms.presentation.ListOfFilmsViewModel
import com.example.network.createRetrofitService
import com.example.network.getRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listOfFilmsModule = module {

	factory { createRetrofitService<ListOfFilmsApi>(getRetrofit()) }

	factory { FilmsMapper() }

	factory<ListOfFilmsRepository> {
		ListOfFilmsRepositoryImpl(
			dataSource = get(),
			mapper = get()
		)
	}

	factory {
		GetAllFilmsUseCase(
			repository = get()
		)
	}

	factory {
		GetFilteredFilmsUseCase(
			repository = get()
		)
	}

	viewModel {
		ListOfFilmsViewModel(
			getAllFilmsUseCase = get(),
			getFilteredFilmsUseCase = get(),
			getStringByIdUseCase = get(),
			router = get()
		)
	}
}
