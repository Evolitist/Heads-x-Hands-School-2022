package com.example.lesson6.data

import com.example.lesson6.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun addNote(text: String)

    suspend fun deleteNote(id: Int)
}