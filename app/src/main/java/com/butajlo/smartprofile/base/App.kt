package com.butajlo.smartprofile.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<App> = DaggerAppComponent.builder().create(this)
}