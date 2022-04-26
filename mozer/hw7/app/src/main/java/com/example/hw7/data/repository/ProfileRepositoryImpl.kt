package com.example.hw7.data.repository

import com.example.hw7.data.mappers.toProfile
import com.example.hw7.domain.NanoPostApiService
import com.example.hw7.domain.model.Profile
import com.example.hw7.domain.repository.ProfileRepository

class ProfileRepositoryImpl(
    private val nanoPostApiService: NanoPostApiService
) : ProfileRepository {

    override suspend fun getProfile(profileId: String): Profile {
        return nanoPostApiService.getProfile(profileId = "evo").toProfile()
    }
}