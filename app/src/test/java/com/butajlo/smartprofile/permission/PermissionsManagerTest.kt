package com.butajlo.smartprofile.permission

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.PermissionChecker
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(PermissionChecker::class)
class PermissionsManagerTest {

    private val context = mock<Context>()
    private val PERMISSION = "android.permission.ACCESS_COARSE_LOCATION"

    private val permissionsManager = PermissionsManager(context)


    @Test
    fun checkPermissions_PermissionGranted_ShouldReturnTrue() {
        PowerMockito.mockStatic(PermissionChecker::class.java)
        whenever(PermissionChecker.checkSelfPermission(context, PERMISSION)).thenReturn(PackageManager.PERMISSION_GRANTED)

        assertEquals(true, permissionsManager.checkPermissions(PERMISSION))
    }

    @Test
    fun checkPermissions_PermisssionDenied_ShouldReturnFalse() {
        PowerMockito.mockStatic(PermissionChecker::class.java)
        whenever(PermissionChecker.checkSelfPermission(context, PERMISSION)).thenReturn(PackageManager.PERMISSION_DENIED)

        assertEquals(false, permissionsManager.checkPermissions(PERMISSION))
    }
}