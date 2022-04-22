package com.example.lesson6.data

import android.os.SystemClock
import com.example.lesson6.model.Note

class NoteRepositoryImpl(
    private val sharedPreferences: SharedPreferenceDataSource =
        SharedPreferenceDataSource()
) : NoteRepository {

    override fun getNotes(): List<Note> {
        return sharedPreferences.getNotes()
    }

    override fun addNote(text: String): Note {
        val note = Note(
            id = SystemClock.elapsedRealtime().toString(),
            text = text
        )
        sharedPreferences.putNote(note)
        return note
    }

    override fun deleteNote(id: String) {
        sharedPreferences.deleteNote(id)
    }
}