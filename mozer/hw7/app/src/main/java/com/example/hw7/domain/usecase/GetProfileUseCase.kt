package com.example.hw7.domain.usecase

import com.example.hw7.data.repository.ProfileRepositoryImpl
import com.example.hw7.domain.model.Profile
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepositoryImpl
) {
    suspend operator fun invoke(): Profile {

        return profileRepository.getProfile("evo")
    }
}