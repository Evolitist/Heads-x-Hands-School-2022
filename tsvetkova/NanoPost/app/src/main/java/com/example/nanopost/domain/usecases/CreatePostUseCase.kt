package com.example.nanopost.domain.usecases

import com.example.nanopost.data.api.ApiService
import com.example.nanopost.data.api.repository.ApiRepository
import com.example.nanopost.domain.model.Post
import javax.inject.Inject

class CreatePostUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {
    suspend operator fun invoke(text: String?, images: List<ByteArray>?): Post {
        return apiRepository.createPost(text, images)
    }
}