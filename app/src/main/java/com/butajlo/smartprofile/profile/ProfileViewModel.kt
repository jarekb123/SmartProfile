package com.butajlo.smartprofile.profile

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.butajlo.smartprofile.domain.usecase.GetLocation
import com.butajlo.smartprofile.extensions.fromMutable
import com.butajlo.smartprofile.extensions.logSelf
import com.butajlo.smartprofile.ui.ObservableViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val getLocation: GetLocation) : ObservableViewModel() {

    private val subscriptions = CompositeDisposable()

    @Bindable
    val profileName = MutableLiveData<String>()

    @Bindable
    val vibrationsEnabled = MutableLiveData<Boolean>()

    private val _ringtoneVolume = MutableLiveData<Int>()
    private val _lat = MutableLiveData<Double>()
    private val _lng = MutableLiveData<Double>()

    val ringtoneVolume = fromMutable(_ringtoneVolume)
    val lat = fromMutable(_lat)
    val lng = fromMutable(_lng)


    override fun onCleared() = subscriptions.clear()

    fun updateCurrentLocation() {
        getLocation()
            .subscribeBy(
                onSuccess = {
                    _lat.value = it.latitude
                    _lng.value = it.longitude
                },
                onError = {
                    it.logSelf(javaClass.simpleName)
                }
            )
            .addTo(subscriptions)
    }

    fun onRingtoneVolumeChanged(progress: Int, fromUser: Boolean) {
        if(fromUser) {
            _ringtoneVolume.value = progress
        }
    }
}