package com.example.lesson6.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lesson6.data.db.entity.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)

abstract class NoteDataBase : RoomDatabase() {

    abstract fun dao(): NoteDAO
}