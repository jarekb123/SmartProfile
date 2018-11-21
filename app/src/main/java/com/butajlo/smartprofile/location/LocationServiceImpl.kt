package com.butajlo.smartprofile.location

import android.location.LocationManager
import android.os.Build
import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.service.LocationService
import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject

class LocationServiceImpl @Inject constructor(
        private val locationProvider: FusedLocationProviderClient,
        private val locationManager: LocationManager
) : LocationService {

    override fun getLatestLocation(): LocationEntity? {
        return try {
            locationProvider.lastLocation.result?.toEntity()
        } catch (se: SecurityException) {
            throw se
        }
    }

    override fun isLocationEnabled(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            locationManager.isLocationEnabled
        } else {
            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            isGpsEnabled || isNetworkEnabled
        }
    }
}