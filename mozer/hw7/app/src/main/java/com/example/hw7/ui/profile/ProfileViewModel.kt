package com.example.hw7.ui.profile

import androidx.lifecycle.*
import com.example.hw7.domain.model.Profile
import com.example.hw7.domain.usecase.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val getProfileUseCase: GetProfileUseCase
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