package com.example.hw7.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.hw7.data.PagedDataResponse
import com.example.hw7.data.mappers.toPost
import com.example.hw7.domain.NanoPostApiService
import com.example.hw7.domain.model.Post
import com.example.hw7.domain.repository.PostRepository
import com.example.hw7.paging.StringKeyedPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject


class PostRepositoryImpl @Inject constructor(
    private val nanoPostApiService: NanoPostApiService
) : PostRepository {
    //    override suspend fun getPosts(profileId: String, count: Int, offset: String): List<Post> {
//        return nanoPostApiService.getPosts(profileId = "evo", count, offset).items.map {
//            it.toPost()
//        }
//
//    }
    override suspend fun getPosts(
        profileId: String,
        count: Int,
        offset: String
    ): Flow<PagingData<Post>> {
        return Pager(PagingConfig(count, enablePlaceholders = false)) {
            StringKeyedPagingSource(nanoPostApiService, profileId)
        }.flow.map {
            it.map { apiPost ->
                apiPost.toPost()
            }
        }
    }
}

