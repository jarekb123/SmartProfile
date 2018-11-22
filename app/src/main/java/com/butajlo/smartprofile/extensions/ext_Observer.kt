package com.butajlo.smartprofile.extensions

import androidx.lifecycle.Observer

fun <R> ((R) -> Unit).asObserver() = Observer<R> { this(it) }