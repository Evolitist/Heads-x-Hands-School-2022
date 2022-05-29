package com.example.nanopost.data.api.repository.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.nanopost.data.api.ApiService
import com.example.nanopost.data.api.models.ApiPost
import com.example.nanopost.data.api.repository.ApiRepository
import com.example.nanopost.data.paging.StringKeyPagingSource
import com.example.nanopost.domain.model.Image
import com.example.nanopost.domain.model.Post
import com.example.nanopost.domain.model.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject


class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ApiRepository {

    override suspend fun getPost(postId: String): Post {
        val apiPost = apiService.getPost(postId)
        return apiPost.toPost()
    }

    override suspend fun getFeed(): Flow<PagingData<Post>> {
        return Pager<String, ApiPost>(
            PagingConfig(30, enablePlaceholders = false),
            "0"
        ) {
            StringKeyPagingSource() {
                apiService.getFeed(it.loadSize, it.key)
            }
        }.flow.map {
            it.map { apiPost ->
                apiPost.toPost()
            }
        }
    }

    override suspend fun getProfile(profileId: String): Profile {
        val apiProfile = apiService.getProfile(profileId)
        return apiProfile.toProfile()
    }

    override suspend fun getPosts(
        profileId: String,
    ): Flow<PagingData<Post>> {
        return Pager(
            PagingConfig(5, enablePlaceholders = false), "0"
        ) {
            StringKeyPagingSource() {
                apiService.getPosts(profileId, it.loadSize, it.key)
            }
        }.flow.map {
            it.map { apiPost ->
                apiPost.toPost()
            }
        }

    }


    override suspend fun getImages(
        profileId: String
    ): Flow<PagingData<Image>> {
       return Pager(
           PagingConfig(4, enablePlaceholders = false), "0"
       ) {
           StringKeyPagingSource() {
               apiService.getImages(profileId, it.loadSize, it.key)
           }
       }.flow.map {
           it.map { apiImage ->
               apiImage.toImage()
           }
       }
    }

    override suspend fun getImage(imageId: String): Image {
       val apiImage = apiService.getImage(imageId)
        return apiImage.toImage()
    }

    override suspend fun createPost(text: String?, images: List<ByteArray>?): Post {
        val image1 = images?.getOrNull(0)?.let {
            MultipartBody.Part.createFormData(
                "image1",
                "image1.jpg",// полное название файла
                RequestBody.create(MediaType.parse("image/jpg"), it)
            )
        }

        val image2 = images?.getOrNull(1)?.let{
            MultipartBody.Part.createFormData(
                "image2",
                "image2.jpg",
                RequestBody.create(MediaType.parse("image/jpg"), it)
            )
        }

        val image3 = images?.getOrNull(2)?.let{
            MultipartBody.Part.createFormData(
                "image3",
                "image3.jpg",
                RequestBody.create(MediaType.parse("image/jpg"), it)
            )
        }

        val image4 = images?.getOrNull(3)?.let{
            MultipartBody.Part.createFormData(
                "image4",
                "image4.jpg",
                RequestBody.create(MediaType.parse("image/jpg"), it)
            )
        }

        val apiPost = apiService.createPost(
            text?.let { RequestBody.create(MediaType.parse("text/plain"), it) },
            image1,
            image2,
            image3,
            image4
        )
        return apiPost.toPost()
    }

    override suspend fun deletePost(postId: String): Boolean {
       return apiService.deletePost(postId).result
    }

    override suspend fun deleteImage(imageId: String): Boolean {
        return apiService.deleteImage(imageId).result
    }
}