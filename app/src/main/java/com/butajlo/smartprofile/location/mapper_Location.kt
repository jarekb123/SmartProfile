package com.butajlo.smartprofile.location

import android.location.Location
import com.butajlo.smartprofile.domain.entity.LocationEntity

fun Location.toEntity() = LocationEntity(latitude, longitude)