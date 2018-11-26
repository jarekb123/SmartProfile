package com.butajlo.smartprofile.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> fromMutable(data: MutableLiveData<T>): LiveData<T> = data