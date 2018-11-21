package com.butajlo.smartprofile.profile

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.butajlo.smartprofile.R
import com.butajlo.smartprofile.base.BaseFragment
import com.butajlo.smartprofile.permission.PermissionsManager
import javax.inject.Inject

class ProfileFragment : BaseFragment() {

    override val layoutRes = R.layout.screen_profile

    @Inject lateinit var permissionsManager: PermissionsManager
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[ProfileViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkLocationPermissions()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSIONS_CODE) {
            if (permissions[0] == Manifest.permission.ACCESS_COARSE_LOCATION
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                logLocation()
            }
        }
    }

    private fun checkLocationPermissions() {
        if (!permissionsManager.checkPermissions(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), REQUEST_PERMISSIONS_CODE)
        } else {
            logLocation()
        }
    }

    private fun logLocation() {
        val location = viewModel.getCurrentLocation()
        Log.d(javaClass.simpleName, location.toString())
    }

    companion object {
        private const val REQUEST_PERMISSIONS_CODE = 1
    }
}