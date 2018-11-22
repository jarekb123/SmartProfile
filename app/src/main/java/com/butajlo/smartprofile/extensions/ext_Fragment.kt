package com.butajlo.smartprofile.extensions

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

fun <T : ViewDataBinding> Fragment.binding() = lazy { view?.let { DataBindingUtil.bind<T>(it) } }