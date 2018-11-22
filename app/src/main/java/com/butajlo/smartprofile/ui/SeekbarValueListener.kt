package com.butajlo.smartprofile.ui

import android.widget.SeekBar

abstract class SeekbarValueListener : SeekBar.OnSeekBarChangeListener {
    override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
    override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
}