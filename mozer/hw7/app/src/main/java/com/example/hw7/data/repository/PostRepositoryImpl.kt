package com.example.hw7.data.repository

import com.example.hw7.data.PagedDataResponse
import com.example.hw7.domain.NanoPostApiService
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.repository.PostRepository

//class PostRepositoryImpl(
//    private val nanoPostApiService: NanoPostApiService
//) : PostRepository {
//    override suspend fun getPosts(): PagedDataResponse<List<Post>> {
//        return nanoPostApiService.getPostsApi()
////            .items.map {
////             it.map {
////                 it.toPost()
////             }
////        }
//    }
//}
