package com.butajlo.smartprofile.ui

import androidx.lifecycle.Observer

fun <R> ((R) -> Unit).asObserver() = Observer<R> { this(it) }