package com.butajlo.smartprofile.main

import com.butajlo.smartprofile.profile.ProfileFragment
import com.butajlo.smartprofile.profile.ProfileModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun bindProfileFragment(): ProfileFragment

}