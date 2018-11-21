package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.service.LocationService
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Maybe
import org.junit.Test

class GetLocationTest {

    val location = LocationEntity(latitude = 0.0, longitude = 0.0)

    val locationService = mock<LocationService> {
        on(it.getLatestLocation()).thenReturn(Maybe.just(location))
    }

    val getLocation = GetLocation(locationService)

    @Test
    fun getLocation_ShouldReturnLocation() {
        getLocation()
            .test()
            .assertResult(location)
    }
}