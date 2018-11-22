package com.butajlo.smartprofile.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.butajlo.daggerx.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    /**
     * Fragment's layout resource ID
     */
    abstract val layoutRes: Int

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    inline fun <reified T : ViewModel> viewModel() = lazy { ViewModelProviders.of(this, viewModelFactory)[T::class.java] }
}