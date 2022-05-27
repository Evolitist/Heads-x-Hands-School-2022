package com.example.lesson5.data.repository

import androidx.paging.PagingData
import com.example.lesson5.data.model.ResultResponse
import com.example.lesson5.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    suspend fun getProfileImages(profileId: String?, count: Int): Flow<PagingData<Image>>

    suspend fun getImage(imageId: String): Image

    suspend fun deleteImage(imageId: String): ResultResponse
}