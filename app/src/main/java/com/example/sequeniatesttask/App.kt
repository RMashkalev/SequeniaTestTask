package com.example.sequeniatesttask

import android.app.Application
import com.example.di.networkModule
import com.example.listoffilms.di.listOfFilmsModule
import com.example.sequeniatesttask.di.mainModule
import com.example.sequeniatesttask.di.navigationModule
import com.example.utils.di.utilsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger(Level.DEBUG)
			androidContext(this@App)

			modules(navigationModule)
			modules(networkModule)

			modules(mainModule)
			modules(listOfFilmsModule)

			modules(utilsModule)
		}
	}
}