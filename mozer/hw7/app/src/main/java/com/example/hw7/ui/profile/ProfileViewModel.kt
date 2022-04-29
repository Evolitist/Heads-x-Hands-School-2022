package com.example.hw7.ui.profile

import androidx.lifecycle.*
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.model.Profile
import com.example.hw7.domain.usecase.GetPostsUseCase
import com.example.hw7.domain.usecase.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val getProfileUseCase: GetProfileUseCase,
    val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    private val _profileLiveData = MutableLiveData<Profile>()
    val profileLiveData: LiveData<Profile> = _profileLiveData
    fun loadProfile() {
        viewModelScope.launch {
            val profile = getProfileUseCase()
            _profileLiveData.value = profile
        }
    }

    private val _postsLiveData = MutableLiveData<List<Post>>()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    fun loadPosts() {
        viewModelScope.launch {
            val posts = getPostsUseCase()
            _postsLiveData.value = posts
        }
    }
}