package com.butajlo.smartprofile.ui

import androidx.lifecycle.ViewModelProvider
import com.butajlo.smartprofile.di.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class UiModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}