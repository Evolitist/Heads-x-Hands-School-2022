package com.example.lesson5.data.repository

import androidx.paging.*
import com.example.lesson5.data.NanoPostApiService
import com.example.lesson5.data.mapers.toPost
import com.example.lesson5.data.model.ResultResponse
import com.example.lesson5.data.paging.StringKeyedPagingSource
import com.example.lesson5.model.Image
import com.example.lesson5.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(

    private val apiService: NanoPostApiService

) : PostRepository {

    override suspend fun getPosts(
        profileId: String?,
        count: Int,
    ): Flow<PagingData<Post>> {
        return Pager(PagingConfig(pageSize = count, enablePlaceholders = false), "0"){
            StringKeyedPagingSource(profileId, apiService)
        }.flow.map {
            it.map { apiPost ->
                apiPost.toPost()
            }
        }
    }

    override suspend fun getPost(postId: String): Post {
        return apiService.getPost(postId).toPost()
    }

    override suspend fun createPost(text: String?, images: List<ByteArray>?): Post {

        val image1 = images?.getOrNull(0)?.let {
            MultipartBody.Part.createFormData("image1", "image.jpg", RequestBody.create(MediaType.parse("image/jpg"), it))
        }
        val image2 = images?.getOrNull(1)?.let {
            MultipartBody.Part.createFormData("image2", "image.jpg", RequestBody.create(MediaType.parse("image/jpg"), it))
        }
        val image3 = images?.getOrNull(2)?.let {
            MultipartBody.Part.createFormData("image3", "image.jpg", RequestBody.create(MediaType.parse("image/jpg"), it))
        }
        val image4 = images?.getOrNull(3)?.let {
            MultipartBody.Part.createFormData("image4", "image.jpg", RequestBody.create(MediaType.parse("image/jpg"), it))
        }

        return apiService.createPost(
           text?.let { RequestBody.create(MediaType.parse("text/plain"),it) }, image1, image2, image3, image4
        ).toPost()


    }

    override suspend fun deletePost(postId: String): ResultResponse {
        return apiService.deletePost(postId)
    }

}