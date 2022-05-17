package com.example.lesson6.data

import com.example.lesson6.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val roomDataSource: RoomDataSource = RoomDataSource()
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return roomDataSource.getNotes()
    }

    override suspend fun addNote(text: String) {
        roomDataSource.putNote(text)

    }

    override suspend fun deleteNote(id: Int) {
        roomDataSource.deleteNote(id)
    }
}