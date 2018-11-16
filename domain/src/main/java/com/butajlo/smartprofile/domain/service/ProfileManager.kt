package com.butajlo.smartprofile.domain.service

import com.butajlo.smartprofile.domain.entity.ProfileEntity

interface ProfileManager {

    fun createProfile(profile: ProfileEntity): ProfileEntity

    fun getProfile(profileName: String): ProfileEntity

    fun updateProfile(profile: ProfileEntity): ProfileEntity
}