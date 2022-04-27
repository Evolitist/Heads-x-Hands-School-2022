package com.example.hw7.domain

import com.example.hw7.data.PagedDataResponse
import com.example.hw7.data.model.ApiPost
import com.example.hw7.data.model.ApiProfile
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface NanoPostApiService {
    @GET("https://nanopost.evolitist.com/api/v1/profile/{profileId}")
    suspend fun getProfile(
        @Path("profileId") profileId:String
    ): ApiProfile

    @GET("https://nanopost.evolitist.com/api/v1/posts/{profileId}")
    suspend fun getPostsApi(
        @Path("profileId") profileId:String
    ): List<ApiPost>
}