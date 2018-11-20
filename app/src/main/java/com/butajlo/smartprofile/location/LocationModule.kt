package com.butajlo.smartprofile.location

import android.content.Context
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides

@Module
object LocationModule {

    @JvmStatic
    @Provides
    fun provideLocationProvider(context: Context) = LocationServices.getFusedLocationProviderClient(context)

}