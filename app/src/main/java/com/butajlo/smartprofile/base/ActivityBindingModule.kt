package com.butajlo.smartprofile.base

import com.butajlo.smartprofile.di.ActivityScope
import com.butajlo.smartprofile.main.MainActivity
import com.butajlo.smartprofile.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity
}