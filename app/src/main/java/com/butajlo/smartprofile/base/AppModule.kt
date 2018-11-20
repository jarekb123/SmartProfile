package com.butajlo.smartprofile.base

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideContext(app: App): Context = app.applicationContext
}