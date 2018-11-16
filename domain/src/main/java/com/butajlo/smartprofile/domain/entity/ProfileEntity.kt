package com.butajlo.smartprofile.domain.entity

data class ProfileEntity(
    val name: String,
    val location: LocationEntity,
    val ringtoneVolume: Int,
    val isVibrationsEnabled: Boolean
)