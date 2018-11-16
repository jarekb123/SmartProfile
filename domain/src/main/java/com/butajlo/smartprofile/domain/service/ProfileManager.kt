package com.butajlo.smartprofile.domain.service

import com.butajlo.smartprofile.domain.entity.ProfileEntity

interface ProfileManager {

    fun createProfile(profile: ProfileEntity): ProfileEntity

    fun updateProfile(profileName: String, profileParams: ProfileEntity.() -> Unit)

    fun getProfile(profileName: String): ProfileEntity
}