package com.example.hw7.domain.usecase

import com.example.hw7.data.repository.PostRepositoryImpl
import com.example.hw7.domain.model.Post
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepositoryImpl
) {
    suspend operator fun invoke(): List<Post> {

        return postRepository.getPosts("evo")
    }
}