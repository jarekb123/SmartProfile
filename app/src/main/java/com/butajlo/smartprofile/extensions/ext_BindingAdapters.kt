package com.butajlo.smartprofile.extensions

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.butajlo.imageswitch.ImageSwitch

@BindingAdapter("stateListener")
fun ImageSwitch.bindListener(onStateUpdatedListener: ImageSwitch.OnStateUpdatedListener) {
    addOnStateUpdateListener(onStateUpdatedListener)
}


fun TextView.bindErrorRes(@StringRes errorRes: Int) {

}