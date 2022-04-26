package com.example.hw7.domain.usecase

import com.example.hw7.App
import com.example.hw7.data.repository.ProfileRepositoryImpl
import com.example.hw7.domain.NanoPostApiService
import com.example.hw7.domain.model.Profile

class GetProfileUseCase(
    private val apiService: NanoPostApiService = App.instance.apiService,
    private val profileRepository: ProfileRepositoryImpl = ProfileRepositoryImpl(apiService)
) {
    suspend operator fun invoke(): Profile {

        return profileRepository.getProfile("evo")
    }
}