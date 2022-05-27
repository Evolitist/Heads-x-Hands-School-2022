package com.example.lesson5.domain

import com.example.lesson5.data.model.ResultResponse
import com.example.lesson5.data.repository.PostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(

    private val postRepository: PostRepository

) {

    suspend operator fun invoke(postId: String): ResultResponse {
        return postRepository.deletePost(postId)
    }
}