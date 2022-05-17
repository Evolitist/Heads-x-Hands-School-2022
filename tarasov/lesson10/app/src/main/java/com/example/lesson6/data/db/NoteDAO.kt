package com.example.lesson6.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lesson6.data.db.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAll(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int): NoteEntity

    @Insert
    suspend fun insertNote(item: NoteEntity)

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNote(id: Int)
}