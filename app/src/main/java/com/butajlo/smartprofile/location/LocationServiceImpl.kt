package com.butajlo.smartprofile.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.util.Log
import androidx.core.content.PermissionChecker
import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.service.LocationService
import com.butajlo.smartprofile.permission.PermissionsManager
import com.google.android.gms.location.FusedLocationProviderClient

class LocationServiceImpl(
    private val context: Context,
    private val permissionsManager: PermissionsManager,
    private val locationProvider: FusedLocationProviderClient,
    private val locationManager: LocationManager
) : LocationService {

    override var isEnabled = PermissionChecker.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    override fun getLatestLocation(): LocationEntity? {
        return try {
            locationProvider.lastLocation.result?.toEntity()
        } catch (se: SecurityException) {
            Log.e(javaClass.simpleName, se.toString())

            null
        }
    }

    override fun isLocationEnabled(): Boolean {
        return locationManager.isLocationEnabled
    }
}