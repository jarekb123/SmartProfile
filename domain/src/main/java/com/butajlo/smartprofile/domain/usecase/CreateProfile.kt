package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.ProfileEntity
import com.butajlo.smartprofile.domain.service.ProfileManager

class CreateProfile(private val profileManager: ProfileManager) {

    operator fun invoke(profile: ProfileEntity): ProfileEntity {
        return profileManager.createProfile(profile)
    }

}