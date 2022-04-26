package com.example.hw7.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PagedDataResponse<T>(
    val count: Int,
    val total: Int,
    val nextFrom: String?,
    val items: List<T>
)
