package com.example.sequeniatesttask.di

import com.example.listoffilms.presentation.ListOfFilmsRouter
import com.example.sequeniatesttask.navigation.buildCicerone
import com.example.sequeniatesttask.navigation.router.ListOfFilmsRouterImpl
import com.example.sequeniatesttask.navigation.router.MainRouterImpl
import com.example.sequeniatesttask.presentation.MainRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

val navigationModule = module {
	single { buildCicerone() }
	single { get<Cicerone<Router>>().router }
	single { get<Cicerone<Router>>().getNavigatorHolder() }

	factory<MainRouter> { MainRouterImpl(get()) }

	factory<ListOfFilmsRouter> { ListOfFilmsRouterImpl(get()) }
}