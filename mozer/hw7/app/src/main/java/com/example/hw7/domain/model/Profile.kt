package com.example.hw7.domain.model

data class Profile(
    val id: String,
    val username: String,
    val displayName: String?,
    val bio: String?,
    val avatarSmall: String?,
    val avatarLarge: String?,
    val subscribersCount : Int,
    val postsCount: Int,
    val imagesCount: Int,
    val images: List<Image>
)
