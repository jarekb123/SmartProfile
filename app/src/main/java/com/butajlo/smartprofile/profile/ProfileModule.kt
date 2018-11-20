package com.butajlo.smartprofile.profile

import androidx.lifecycle.ViewModel
import com.butajlo.smartprofile.di.ViewModelKey
import com.butajlo.smartprofile.domain.service.LocationService
import com.butajlo.smartprofile.domain.usecase.GetLocation
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGetLocationUseCase(locationService: LocationService) = GetLocation(locationService)
    }

}