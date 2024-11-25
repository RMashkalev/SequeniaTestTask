package com.example.sequeniatesttask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sequeniatesttask.presentation.MainViewModel
import com.example.squeniatesttask.R
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

	private val navigatorHolder: NavigatorHolder by inject()
	private val navigator = AppNavigator(this, R.id.main_activity)
	private val viewModel: MainViewModel by viewModel()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity_frame)
		if (savedInstanceState == null) {
			viewModel.setStartScreen()
		}
	}

	override fun onResume() {
		super.onResume()
		navigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		super.onPause()
		navigatorHolder.removeNavigator()
	}
}