package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.ProfileEntity
import com.butajlo.smartprofile.domain.service.ProfileManager
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Test

class CreateProfileTest {

    private val profile = ProfileEntity(
        name = "profile_name",
        isVibrationsEnabled = true,
        location = mock(),
        ringtoneVolume = 0
    )

    private val profileManager = mock<ProfileManager>()
    private val createProfile = CreateProfile(profileManager)

    @Test
    fun createProfile_ShouldCreateProfileViaProfileManager() {
        createProfile(profile)
        verify(profileManager).createProfile(profile)
    }

}