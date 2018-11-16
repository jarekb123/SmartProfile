package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.ProfileEntity
import com.butajlo.smartprofile.domain.service.ProfileManager

class UpdateProfile(private val profileManager: ProfileManager) {

    operator fun invoke(profile: ProfileEntity) {
        profileManager.updateProfile(profile)
    }

}