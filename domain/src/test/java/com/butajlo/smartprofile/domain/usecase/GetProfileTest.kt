package com.butajlo.smartprofile.domain.usecase

import com.butajlo.smartprofile.domain.entity.ProfileEntity
import com.butajlo.smartprofile.domain.service.ProfileManager
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.*
import org.junit.Test

class GetProfileTest {

    private val PROFILE_NAME = "profile_name"

    private val profile = mock<ProfileEntity>()
    private val profileManager = mock<ProfileManager> {
        on(it.getProfile(PROFILE_NAME)).thenReturn(profile)
    }

    private val getProfile = GetProfile(profileManager)

    @Test
    fun getProfile_CheckReturn_ShouldReturnProfile() {
        assertEquals(profile, getProfile(PROFILE_NAME))
    }


}