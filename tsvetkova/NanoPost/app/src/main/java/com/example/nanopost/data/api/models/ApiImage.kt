package com.example.nanopost.data.api.models

import com.example.nanopost.domain.model.Image
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiImage(
    val id: String,
    val owner: ApiProfileCompact,
    val dateCreated: Long,
    val sizes: List<ApiImageSize>
){
    fun toImage() : Image {
        return Image(
            id = this.id,
            owner = this.owner.toProfileCompact(),
            dateCreated = this.dateCreated,
            sizes = this.sizes.map {
                it.toImageSize()
            }
        )
    }
}