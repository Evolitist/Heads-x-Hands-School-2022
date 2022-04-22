package com.example.lesson6

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}

val Context.prefs by preferencesDataStore("prefs")