package com.butajlo.smartprofile.location

import android.location.Location
import android.location.LocationManager
import com.butajlo.smartprofile.common.stubBuildSdkVersion
import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.permission.PermissionsManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Task
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Test

class LocationServiceImplTest {

    private val location = mock<Location> {
        on(it.latitude).thenReturn(30.0)
        on(it.longitude).thenReturn(20.0)
    }
    private val locationEntity = LocationEntity(latitude = 30.0, longitude = 20.0)

    private val permissionsManager = mock<PermissionsManager>()
    private val lastLocationTask = mock<Task<Location>>()
    private val locationProvider = mock<FusedLocationProviderClient> {
        on(it.lastLocation).thenReturn(lastLocationTask)
    }
    private val locationManager = mock<LocationManager>()

    private val locationService = LocationServiceImpl(permissionsManager, locationProvider, locationManager)

    @Test
    fun getLatestLocation_LocationProviderReturnsLocation_CheckReturnValue() {
        whenever(locationProvider.lastLocation.result).thenReturn(location)

        assertEquals(locationEntity, locationService.getLatestLocation())
    }

    @Test(expected = SecurityException::class)
    fun getLatestLocation_LocationProviderThrowsSecurityException_ShouldReturnNull() {
        whenever(locationProvider.lastLocation.result).thenThrow(SecurityException())

        locationService.getLatestLocation()
    }

    @Test
    fun isLocationEnabled_Sdk27_GpsEnabledNetworkDisabled_ShouldReturnTrue() {
        stubBuildSdkVersion(27)
        whenever(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)).thenReturn(false)
        whenever(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)).thenReturn(true)

        assertEquals(true, locationService.isLocationEnabled())
    }

    @Test
    fun isLocationEnabled_Sdk27_GpsDisabledNetworkEnabled_ShouldReturnTrue() {
        stubBuildSdkVersion(27)
        whenever(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)).thenReturn(true)
        whenever(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)).thenReturn(false)

        assertEquals(true, locationService.isLocationEnabled())
    }

    @Test
    fun isLocationEnabled_Sdk27_GpsDisabledNetworkDisabled_ShouldReturnFalse() {
        stubBuildSdkVersion(27)
        whenever(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)).thenReturn(false)
        whenever(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)).thenReturn(false)

        assertEquals(false, locationService.isLocationEnabled())
    }

    @Test
    fun isLocationEnabled_Sdk28_LocationEnabled_ShouldReturnTrue() {
        stubBuildSdkVersion(28)
        whenever(locationManager.isLocationEnabled).thenReturn(true)

        assertEquals(true, locationService.isLocationEnabled())
    }
}