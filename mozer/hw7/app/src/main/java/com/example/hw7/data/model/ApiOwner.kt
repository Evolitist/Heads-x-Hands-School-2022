package com.example.hw7.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiOwner(
    val id: String,
    val username: String,
    val subscribed: Boolean
)
