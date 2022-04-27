package com.example.hw7.data.repository

import com.example.hw7.data.PagedDataResponse
import com.example.hw7.data.mappers.toPost
import com.example.hw7.domain.NanoPostApiService
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.repository.PostRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class PostRepositoryImpl @Inject constructor(
    private val nanoPostApiService: NanoPostApiService
) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return nanoPostApiService.getPostsApi(profileId = "evo").map {
            it.toPost()
        }

    }
}
