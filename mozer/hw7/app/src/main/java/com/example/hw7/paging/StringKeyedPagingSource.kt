package com.example.hw7.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.hw7.data.model.ApiPost
import com.example.hw7.domain.NanoPostApiService
import java.lang.Exception
import java.util.concurrent.CancellationException

class StringKeyedPagingSource(
    private val apiService: NanoPostApiService,
    private val profileId: String
) : PagingSource<String, ApiPost>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ApiPost> = try {
        val response = apiService.getPosts(profileId, params.loadSize, params.key)

        LoadResult.Page(
            data = response.items,
            prevKey = null,
            nextKey = response.offset.takeIf { response.count >= params.loadSize }
        )

    } catch (e: CancellationException) {
        throw e

    } catch (e: Exception) {
        LoadResult.Error(e)
    }

    override fun getRefreshKey(state: PagingState<String, ApiPost>): String? = null
}