package com.butajlo.smartprofile.common

import android.os.Build
import javax.inject.Inject

class SdkChecker @Inject constructor() {

    /**
     * @return true if Build.VERSION.SDK_INT is higher than above
     */
    fun isCurrentSdkAbove(sdkVersion: Int): Boolean {
        return Build.VERSION.SDK_INT > sdkVersion
    }

}