package com.example.lesson6

import android.app.Application
import androidx.room.Room
import com.example.lesson6.data.db.NoteDataBase

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    val database by lazy {
        Room.databaseBuilder(
            this,
            NoteDataBase::class.java,
            "notes database",
        ).build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}