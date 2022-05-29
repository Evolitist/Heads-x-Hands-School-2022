package com.example.nanopost.domain.usecases

import androidx.paging.PagingData
import com.example.nanopost.data.api.repository.ApiRepository
import com.example.nanopost.domain.model.Image
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {
    suspend operator fun invoke(imageId: String): Image {
        return apiRepository.getImage(imageId)
    }

}