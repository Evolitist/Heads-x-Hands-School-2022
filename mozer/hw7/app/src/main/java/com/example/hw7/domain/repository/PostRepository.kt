package com.example.hw7.domain.repository

import androidx.paging.PagingData
import com.example.hw7.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    suspend fun getPost(postId: String): Post
    suspend fun getPosts(profileId: String, count: Int, offset: String): Flow<PagingData<Post>>
}