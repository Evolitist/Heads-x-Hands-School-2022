package com.example.hw7.ui.profile

import androidx.lifecycle.*
import androidx.paging.PagingData
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.model.Profile
import com.example.hw7.domain.usecase.GetPostsUseCase
import com.example.hw7.domain.usecase.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val getProfileUseCase: GetProfileUseCase,
    val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    private val _profileLiveData = MutableLiveData<Profile>()
    val profileLiveData: LiveData<Profile> = _profileLiveData

    private val _postsLiveData = MutableLiveData<PagingData<Post>>()
    val postsLiveData: LiveData<PagingData<Post>> = _postsLiveData

    fun loadData() {
        viewModelScope.launch {

            val profile = getProfileUseCase()
            _profileLiveData.value = profile

            getPostsUseCase().collect {
                _postsLiveData.value = it
            }
        }
    }
}