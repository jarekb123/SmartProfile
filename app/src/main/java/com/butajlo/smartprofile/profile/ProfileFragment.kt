package com.butajlo.smartprofile.profile

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.databinding.adapters.SeekBarBindingAdapter
import androidx.lifecycle.Observer
import com.butajlo.smartprofile.R
import com.butajlo.smartprofile.base.BaseFragment
import com.butajlo.smartprofile.databinding.ScreenProfileBinding
import com.butajlo.smartprofile.extensions.binding
import com.butajlo.smartprofile.extensions.logSelf
import com.butajlo.smartprofile.permission.PermissionsManager
import javax.inject.Inject

class ProfileFragment : BaseFragment() {
    override val layoutRes = R.layout.screen_profile

    @Inject lateinit var permissionsManager: PermissionsManager

    private val viewModel: ProfileViewModel by viewModel()

    private val dataBinding: ScreenProfileBinding? by binding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkLocationPermissions()

        dataBinding?.setLifecycleOwner(this)
        dataBinding?.viewModel = viewModel
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
        viewModel.updateCurrentLocation()
    }

    companion object {
        private const val REQUEST_PERMISSIONS_CODE = 1
    }
}