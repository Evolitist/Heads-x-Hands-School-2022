package com.example.nanopost.domain.usecases

import com.example.nanopost.data.api.models.AuthData
import com.example.nanopost.data.api.models.TokenResponse
import com.example.nanopost.data.api.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): TokenResponse {
        return authRepository.register(username, password)
    }
}