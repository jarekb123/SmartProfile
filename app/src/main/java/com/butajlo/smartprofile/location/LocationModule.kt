package com.butajlo.smartprofile.location

import android.content.Context
import android.location.LocationManager
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

        @JvmStatic
        @Singleton
        @Provides
        fun provideLocationManager(context: Context): LocationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

}