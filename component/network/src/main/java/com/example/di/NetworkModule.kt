package com.example.di

import com.example.network.provideMoshi
import com.example.network.provider.OkHttpClientProvider
import com.example.network.provider.RetrofitProvider
import org.koin.dsl.module

const val BASE_URL = "https://s3-eu-west-1.amazonaws.com/sequeniatesttask"

val networkModule = module {
	single { provideMoshi() }

	single {
		OkHttpClientProvider(
			interceptors = listOf()
		)
	}

	single {
		RetrofitProvider(
			okHttpClient = get(),
			moshi = get(),
			url = BASE_URL
		)
	}
}