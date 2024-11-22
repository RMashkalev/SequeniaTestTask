package com.example.listoffilms.domain.usecase

import android.content.Context

class GetStringByIdUseCase(private val context: Context) {

	operator fun invoke(id: Int): String {
		return context.getString(id)
	}
}