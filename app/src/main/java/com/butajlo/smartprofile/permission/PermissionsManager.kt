package com.butajlo.smartprofile.permission

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.PermissionChecker
import javax.inject.Inject

class PermissionsManager @Inject constructor(private val context: Context) {

    fun checkPermissions(permission: String) =
        PermissionChecker.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

}