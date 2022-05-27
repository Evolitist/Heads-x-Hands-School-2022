package com.example.lesson5.data.repository

import android.content.SharedPreferences

interface PreferencesRepository {
    val sharedPreferences: SharedPreferences

    fun addUserId(userId: String)

    fun getUserId(): String?

    fun addToken(token: String, userId: String)

    fun getToken(): String?
}