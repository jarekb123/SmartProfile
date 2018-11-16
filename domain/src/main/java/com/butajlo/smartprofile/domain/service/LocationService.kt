package com.butajlo.smartprofile.domain.service

import com.butajlo.smartprofile.domain.entity.LocationEntity

interface LocationService {

    /**
     * Location Service enabled status
     */
    var isEnabled: Boolean

    /**
     * @return If latest location service is enabled returns last known location,
     *         otherwise returns null
     */
    fun getLatestLocation(): LocationEntity?

}