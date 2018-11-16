package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.service.LocationService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class EnableLocationServiceTest {

    private val locationService = mock<LocationService>()

    private val enableLocationService = EnableLocationService(locationService)

    @Test
    fun enableService_ShouldEnableService() {
        enableLocationService(isEnabled = true)
        verify(locationService).isEnabled = true
    }

    @Test
    fun disableService_ShouldDisableService() {
        enableLocationService(isEnabled = false)
        verify(locationService).isEnabled = false
    }
}