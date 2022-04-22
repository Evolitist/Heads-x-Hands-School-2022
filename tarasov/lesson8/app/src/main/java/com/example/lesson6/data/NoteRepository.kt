package com.example.lesson6.data

import com.example.lesson6.model.Note

interface NoteRepository {

    fun getNotes(): List<Note>

    fun addNote(text: String): Note

    fun deleteNote(id: String)
}