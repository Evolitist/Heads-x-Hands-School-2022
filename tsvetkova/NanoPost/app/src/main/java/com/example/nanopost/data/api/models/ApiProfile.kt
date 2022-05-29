package com.example.nanopost.data.api.models

import com.example.nanopost.domain.model.Image
import com.example.nanopost.domain.model.Profile
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiProfile(
    val id: String,
    val username: String,
    val displayName: String?,
    val bio: String?,
    val avatarId: String?,
    val avatarSmall: String?,
    val avatarLarge: String?,
    val subscribed: Boolean,
    val subscribersCount: Int,
    val postsCount: Int,
    val imagesCount: Int,
    val images: List<ApiImage>
) {
    fun toProfile(): Profile {
        return Profile(
            id = this.id,
            username = this.username,
            displayName = this.displayName,
            bio = this.bio,
            avatarId = this.avatarId,
            avatarSmall = this.avatarSmall,
            avatarLarge = this.avatarLarge,
            subscribed = this.subscribed,
            subscribersCount = this.subscribersCount,
            postsCount = this.postsCount,
            imagesCount = this.imagesCount,
            images = this.images.map {
                it.toImage()
            }
        )
    }
}