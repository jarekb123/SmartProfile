package com.butajlo.smartprofile.profile

import androidx.lifecycle.ViewModel
import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.usecase.GetLocation
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val getLocation: GetLocation) : ViewModel() {

    fun getCurrentLocation(): LocationEntity? = getLocation()

}