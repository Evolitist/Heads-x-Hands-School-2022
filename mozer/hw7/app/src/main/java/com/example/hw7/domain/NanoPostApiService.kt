package com.example.hw7.domain

import com.example.hw7.data.PagedDataResponse
import com.example.hw7.data.model.ApiPost
import com.example.hw7.data.model.ApiProfile
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NanoPostApiService {

    @GET("https://nanopost.evolitist.com/api/v1/profile/{profileId}")
    suspend fun getProfile(
        @Path("profileId") profileId: String
    ): ApiProfile

    @GET("https://nanopost.evolitist.com/api/v1/posts/{profileId}")
    suspend fun getPosts(
        @Path("profileId") profileId: String,
        @Query("count") count: Int,
        @Query("offset") offset: String?
    ): PagedDataResponse<ApiPost>

    @GET("https://nanopost.evolitist.com/api/v1/post/{postId}")
    suspend fun getPost(
        @Path("postId") postId: String
    ): ApiPost
}