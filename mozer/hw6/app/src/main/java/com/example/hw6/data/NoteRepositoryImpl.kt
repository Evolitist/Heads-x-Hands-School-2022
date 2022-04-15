package com.example.hw6.data

import android.os.SystemClock
import com.example.hw6.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val sharedPreferencesDataSource: SharedPreferencesDataSource = SharedPreferencesDataSource()
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return sharedPreferencesDataSource.getNotes()
    }

    override suspend fun addNote(text: String): Note {
//        val note = MockDataSource.generateNote(text)
//        sharedPreferencesDataSource.putNote(note)
//        return note
        val note = Note(
            id = SystemClock.elapsedRealtime().toString(),
            text = text
        )
        sharedPreferencesDataSource.putNote(note)
        return note
    }

    override suspend fun deleteNote(note: Note) {
        sharedPreferencesDataSource.deleteNote(note)
    }

}