package com.example.hw7.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.usecase.GetPostsUseCase
import com.example.hw7.domain.usecase.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {
    private val _postsLiveData = MutableLiveData<List<Post>>()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    fun loadPosts() {
        viewModelScope.launch {
            val posts = getPostsUseCase()
            _postsLiveData.value = posts
        }
    }
}