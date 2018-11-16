package com.butajlo.smartprofile.domain.entity

import com.thinkinglogic.builder.annotation.Builder

@Builder
data class ProfileEntity(
    val name: String,
    val location: LocationEntity,
    val ringtoneVolume: Int,
    val isVibrationsEnabled: Boolean
)