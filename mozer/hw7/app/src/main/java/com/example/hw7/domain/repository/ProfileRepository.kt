package com.example.hw7.domain.repository

import com.example.hw7.domain.model.Profile

interface ProfileRepository {
    suspend fun getProfile(profileId:String) : Profile
}