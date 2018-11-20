package com.butajlo.smartprofile.domain.service

import com.butajlo.smartprofile.domain.entity.LocationEntity

interface LocationService {

    /**
     * @return If latest location service is enabled returns last known location,
     *         otherwise returns null
     */
    fun getLatestLocation(): LocationEntity?

    /**
     * Checks if location service is enabled
     */
    fun isLocationEnabled(): Boolean
}