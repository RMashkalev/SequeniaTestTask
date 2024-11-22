package com.example.utils.di

import com.example.utils.usecase.GetStringByIdUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilsModule = module {

	factory {
		GetStringByIdUseCase(
			context = androidContext()
		)
	}
}