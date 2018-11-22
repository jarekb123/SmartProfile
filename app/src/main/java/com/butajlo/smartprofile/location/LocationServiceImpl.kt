package com.butajlo.smartprofile.location

import android.location.LocationManager
import android.os.Build
import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.service.LocationService
import com.butajlo.smartprofile.rx.task.toSingle
import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject
import io.reactivex.Single

class LocationServiceImpl @Inject constructor(
        private val locationProvider: FusedLocationProviderClient,
        private val locationManager: LocationManager
) : LocationService {

    @Throws(SecurityException::class)
    override fun getLatestLocation(): Single<LocationEntity> {
        return locationProvider.lastLocation
            .toSingle()
            .map { it.toEntity() }
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