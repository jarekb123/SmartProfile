package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.ProfileEntity
import com.butajlo.smartprofile.domain.service.ProfileManager

class GetProfile(private val profileManager: ProfileManager) {

    operator fun invoke(profileName: String): ProfileEntity {
        return profileManager.getProfile(profileName = profileName)
    }
}