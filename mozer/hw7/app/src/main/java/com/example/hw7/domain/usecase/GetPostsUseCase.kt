package com.example.hw7.domain.usecase

import androidx.paging.PagingData
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    suspend operator fun invoke(): Flow<PagingData<Post>> {
        return postRepository.getPosts("evo",10,"10")
    }
}