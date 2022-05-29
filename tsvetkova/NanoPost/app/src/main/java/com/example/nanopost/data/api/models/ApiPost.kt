package com.example.nanopost.data.api.models

import com.example.nanopost.domain.model.Image
import com.example.nanopost.domain.model.Post
import com.example.nanopost.domain.model.ProfileCompact
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiPost(
    val id: String,
    val owner: ApiProfileCompact,
    val dateCreated: Long,
    val text: String?,
    val images: List<ApiImage>,
    val likes: ApiLikes
) {

    fun toPost(): Post {
        return Post(
            id = this.id,
            owner = this.owner.toProfileCompact(),
            dateCreated = this.dateCreated,
            text = this.text,
            images = this.images.map {
                it.toImage()
            },
            likes = this.likes.toLikes()
        )
    }
}