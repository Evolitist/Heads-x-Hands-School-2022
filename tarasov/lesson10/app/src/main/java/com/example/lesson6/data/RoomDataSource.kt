package com.example.lesson6.data

import com.example.lesson6.App
import com.example.lesson6.data.db.NoteDataBase
import com.example.lesson6.data.db.entity.NoteEntity
import com.example.lesson6.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomDataSource @Inject constructor(

    private val database: NoteDataBase

) {

    private val dao get() = database.dao()

    fun getNotes(): Flow<List<Note>> {
        return dao.getAll().map { notes -> notes.map { Note(it.id, it.text) } }

    }

    suspend fun putNote(text: String) {
        dao.insertNote(
            NoteEntity(id = 0, text = text)
        )
    }

    suspend fun deleteNote(id: Int) {
        dao.deleteNote(id)
    }
}