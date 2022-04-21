package com.example.hw6.data

import android.os.SystemClock
import com.example.hw6.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val roomDataSource: RoomDataSource = RoomDataSource()
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return roomDataSource.getNotes()
    }

    override suspend fun addNote(text: String): Note {
        val note = Note(
            id = SystemClock.elapsedRealtime().toInt(),
            text = text
        )
        roomDataSource.putNote(note)
        return note
    }

    override suspend fun deleteNote(note: Note) {
        roomDataSource.deleteNote(note)
    }

}