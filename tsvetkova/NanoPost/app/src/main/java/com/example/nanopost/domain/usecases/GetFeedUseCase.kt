package com.example.nanopost.domain.usecases

import androidx.paging.PagingData
import com.example.nanopost.data.api.repository.ApiRepository
import com.example.nanopost.domain.model.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {
    suspend operator fun invoke() : Flow<PagingData<Post>> {
        return apiRepository.getFeed()
    }
}