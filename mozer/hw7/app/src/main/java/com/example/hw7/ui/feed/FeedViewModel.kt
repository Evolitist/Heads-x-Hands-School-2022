package com.example.hw7.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.usecase.GetPostsUseCase
import com.example.hw7.domain.usecase.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {

    private val _postsLiveData = MutableLiveData<PagingData<Post>>()
    val postsLiveData: LiveData<PagingData<Post>> = _postsLiveData

    fun loadPosts() {
        viewModelScope.launch {
            getPostsUseCase().collect {
                _postsLiveData.value = it
            }

        }
    }
}