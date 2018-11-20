package com.butajlo.smartprofile.location

import android.content.Context
import com.butajlo.smartprofile.domain.service.LocationService
import com.google.android.gms.location.LocationServices
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class LocationModule {

    @Singleton
    @Binds
    abstract fun bindLocationService(locationServiceImpl: LocationServiceImpl): LocationService

    @Module
    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun provideLocationProvider(context: Context) = LocationServices.getFusedLocationProviderClient(context)
    }

}