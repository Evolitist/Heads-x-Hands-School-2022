package com.example.lesson6.data

import android.os.SystemClock
import com.example.lesson6.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val sharedPreferences: SharedPreferenceDataSource =
        SharedPreferenceDataSource()
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return sharedPreferences.getNotes()
    }

    override suspend fun addNote(text: String): Note {
        val note = Note(
            id = SystemClock.elapsedRealtime().toString(),
            text = text
        )
        sharedPreferences.putNote(note)
        return note
    }

    override suspend fun deleteNote(id: String) {
        sharedPreferences.deleteNote(id)
    }
}