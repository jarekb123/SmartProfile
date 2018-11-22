package com.butajlo.smartprofile.extensions

import android.util.Log

fun Any.logSelf() {
    Log.d(javaClass.simpleName, toString())
}

fun Any.logSelf(tag: String) {
    Log.d(tag, toString())
}