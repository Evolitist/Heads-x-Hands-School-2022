package com.example.hw7.domain.repository

interface PreferencesRepository {

    fun getToken(): String?
    fun addToken(token: String)
}