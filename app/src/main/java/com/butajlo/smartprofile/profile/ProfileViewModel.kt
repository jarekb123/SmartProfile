package com.butajlo.smartprofile.profile

import android.widget.SeekBar
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.butajlo.smartprofile.domain.entity.LocationEntity
import com.butajlo.smartprofile.domain.usecase.GetLocation
import com.butajlo.smartprofile.ui.ObservableViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val getLocation: GetLocation) : ObservableViewModel() {

    private val subscriptions = CompositeDisposable()
    private val currentLocation = MutableLiveData<LocationEntity>()

    @Bindable
    val profileName = MutableLiveData<String>()

    @Bindable
    val vibrationsEnabled = MutableLiveData<Boolean>()

    private val _ringtoneVolume = MutableLiveData<Int>()
    val ringtoneVolume: LiveData<Int>
        get() = _ringtoneVolume

    override fun onCleared() = subscriptions.clear()

    fun updateCurrentLocation() {
        getLocation()
            .subscribeBy(
                onSuccess = currentLocation::setValue
            )
            .addTo(subscriptions)
    }

    fun SeekBar.onRingtoneVolumeChanged(progress: Int, fromUser: Boolean) {
        if(fromUser) {
            _ringtoneVolume.value = progress
        }
    }

    fun currentLocation(): LiveData<LocationEntity> = currentLocation

}