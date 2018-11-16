package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.service.LocationService
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class GetLocationTest {

    val location = LocationEntity(latitude = 0.0f, longitude = 0.0f)

    val locationService = mock<LocationService> {
        on(it.getLatestLocation()).thenReturn(location)
    }

    val getLocation = GetLocation(locationService)

    @Test
    fun getLocation_ShouldReturnLocation() {
        assert(getLocation() == location)
    }
}