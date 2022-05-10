package com.example.hw7.domain.usecase

import com.example.hw7.domain.model.Profile
import com.example.hw7.domain.repository.ProfileRepository
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Profile {

        return profileRepository.getProfile("evo")
    }
}