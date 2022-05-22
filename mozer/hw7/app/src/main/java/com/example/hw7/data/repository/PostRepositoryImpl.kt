package com.example.hw7.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.hw7.data.PagedDataResponse
import com.example.hw7.data.mappers.toPost
import com.example.hw7.data.model.ApiPost
import com.example.hw7.data.model.ResultResponse
import com.example.hw7.domain.NanoPostApiService
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.repository.PostRepository
import com.example.hw7.paging.StringKeyedPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

import javax.inject.Inject


class PostRepositoryImpl @Inject constructor(
    private val nanoPostApiService: NanoPostApiService
) : PostRepository {

    override suspend fun getFeed(): Flow<PagingData<Post>> {
        return Pager(PagingConfig(30, enablePlaceholders = false), "0") {
            StringKeyedPagingSource {
                nanoPostApiService.getFeed(it.loadSize, it.key)
            }
        }.flow.map {
            it.map { apiPost ->
                apiPost.toPost()
            }
        }
    }

    override suspend fun getPost(postId: String): Post {
        return nanoPostApiService.getPost(postId).toPost()

    }

    override suspend fun createPost(text: String?, list: List<ByteArray>?): Post {
        /*val (image0, image1, image2, image3) = array?.mapIndexed { index, it ->
            MultipartBody.Part.createFormData(
                "image${index.inc()}",
                "image$index.jpg",
                it.toRequestBody("image/*".toMediaType())
            )
        }.orEmpty()*/*/
        var image0: RequestBody? = null
        list?.getOrNull(0)?.let {
            image0 = it.toRequestBody("image/*".toMediaType())
        }
        var image1: RequestBody? = null
        list?.getOrNull(0)?.let {
            image1 = it.toRequestBody("image/*".toMediaType())
        }
        var image2: RequestBody? = null
        list?.getOrNull(0)?.let {
            image2 = it.toRequestBody("image/*".toMediaType())
        }
        var image3: RequestBody? = null
        list?.getOrNull(0)?.let {
            image3 = it.toRequestBody("image/*".toMediaType())
        }

        return nanoPostApiService.createPost(
            text?.toRequestBody(),
            image0,
            image1,
            image2,
            image3
        ).toPost()
    }

    override suspend fun deletePost(postId: String): Boolean {
        return nanoPostApiService.deletePost(postId).result
    }
}