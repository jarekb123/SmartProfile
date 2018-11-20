package com.butajlo.smartprofile.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.butajlo.daggerx.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    /**
     * Fragment's layout resource ID
     */
    abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }
}