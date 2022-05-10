package com.example.hw7.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.hw7.domain.repository.PreferencesRepository
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesRepository {

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
    }

    override fun getToken(): String? {
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, null).toString()
    }

    override fun addToken(token: String) {
        sharedPreferences.edit {
            putString(KEY_ACCESS_TOKEN, token)
        }
    }


}