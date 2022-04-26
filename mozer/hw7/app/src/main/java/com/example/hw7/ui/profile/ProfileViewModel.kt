package com.example.hw7.ui.profile

import androidx.lifecycle.*
import com.example.hw7.domain.model.Profile
import com.example.hw7.domain.usecase.GetProfileUseCase
import kotlinx.coroutines.launch

class ProfileViewModel(
    val getProfileUseCase: GetProfileUseCase = GetProfileUseCase()
) : ViewModel() {

    private val _profileLiveData = MutableLiveData<Profile>()
    val profileLiveData: LiveData<Profile> = _profileLiveData
    fun loadProfile() {
        viewModelScope.launch {
            val profile = getProfileUseCase()
            _profileLiveData.value = profile
        }
    }
}