package com.github.trendrepo.base

import androidx.lifecycle.ViewModel
import com.github.trendrepo.injection.component.DaggerViewModelInjector
import com.github.trendrepo.injection.component.ViewModelInjector
import com.github.trendrepo.injection.module.NetworkModule
import com.github.trendrepo.viewmodel.MainActivityViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainActivityViewModel -> injector.inject(this)
        }
    }
}