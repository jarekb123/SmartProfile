package com.butajlo.smartprofile.location

import android.Manifest
import android.location.LocationManager
import android.os.Build
import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.service.LocationService
import com.butajlo.smartprofile.permission.PermissionsManager
import com.google.android.gms.location.FusedLocationProviderClient

class LocationServiceImpl(
    private val permissionsManager: PermissionsManager,
    private val locationProvider: FusedLocationProviderClient,
    private val locationManager: LocationManager
) : LocationService {

    override var isEnabled = true

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

    fun isLocationPermissionsGranted(): Boolean {
        return permissionsManager.checkPermissions(Manifest.permission.ACCESS_COARSE_LOCATION) ||
                permissionsManager.checkPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}