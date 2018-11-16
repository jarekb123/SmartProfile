package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.service.LocationService

class EnableLocationService(private val locationService: LocationService) {

    operator fun invoke(isEnabled: Boolean) {
        locationService.isEnabled = isEnabled
    }

}