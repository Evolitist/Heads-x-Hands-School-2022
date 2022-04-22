package com.example.lesson6.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.lesson6.App
import com.example.lesson6.model.Note

class SharedPreferenceDataSource(
    private val sharedPreferences: SharedPreferences =
        App.instance.getSharedPreferences("notes", Context.MODE_PRIVATE)
) {

    fun getNotes(): List<Note> {
        return sharedPreferences.all.map {
            Note(
                it.key,
                it.value.toString(),
            )
        }.sortedByDescending {
            it.id
        }
    }

    fun putNote(note: Note) {
        sharedPreferences.edit {
            putString(note.id, note.text)
        }
    }

    fun deleteNote(id: String) {
        sharedPreferences.edit {
            remove(id)
        }
    }
}