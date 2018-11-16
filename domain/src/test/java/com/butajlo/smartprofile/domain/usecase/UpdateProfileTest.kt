package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.ProfileEntity
import com.butajlo.smartprofile.domain.service.ProfileManager
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class UpdateProfileTest {

    private val profileManager = mock<ProfileManager>()
    private val profile = mock<ProfileEntity>()

    private val updateProfile = UpdateProfile(profileManager)

    @Test
    fun updateProfile_VerifyProfileManagerUpdateCall() {
        updateProfile(profile)
        verify(profileManager).updateProfile(profile)
    }

}