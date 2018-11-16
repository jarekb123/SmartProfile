package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.service.LocationService

class GetLocation(private val locationService: LocationService) {

    operator fun invoke() = locationService.getLatestLocation()

}