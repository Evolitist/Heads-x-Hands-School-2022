package com.example.lesson5.data.mapers

import com.example.lesson5.data.model.*
import com.example.lesson5.model.*

fun ApiProfile.toProfile(): Profile {
    return Profile(
        id,
        username,
        avatarId,
        avatarLarge,
        avatarId,
        avatarSmall,
        avatarLarge,
        subscribed,
        subscribersCount,
        postsCount,
        imagesCount,
        images.map {
            it.toImage()
        }
    )
}

fun ApiPost.toPost(): Post {
    return Post(id, owner.toProfileCompact(), dateCreated, text, images.map {
        it.toImage()
    })
}

fun ApiImage.toImage(): Image {
    return Image(id, owner.toProfileCompact(), dateCreated, sizes.map {
        it.toImageSize()
    })
}

fun ApiImageSize.toImageSize(): ImageSize {
    return ImageSize(width, height, url)
}

fun ApiProfileCompact.toProfileCompact(): ProfileCompact {
    return ProfileCompact(id, username, displayName, avatarUrl, subscribed)
}