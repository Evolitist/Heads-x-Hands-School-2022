package com.example.hw7.domain.repository

import com.example.hw7.data.PagedDataResponse
import com.example.hw7.domain.model.Post

interface PostRepository {
    suspend fun getPosts() : List<Post>
}