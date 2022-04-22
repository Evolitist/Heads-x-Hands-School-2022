package com.example.lesson6.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.lesson6.App
import com.example.lesson6.model.Note
import com.example.lesson6.prefs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SharedPreferenceDataSource(
    private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences> = App.instance.prefs
) {

    fun getNotes(): Flow<List<Note>> {
        return dataStore.data
            .map { prefs ->
                prefs.asMap().map {
                    Note(it.key.name, it.value.toString(),
                    )
                }.sortedByDescending {
                    it.id
                }
            }
    }

    suspend fun putNote(note: Note) {
        dataStore.edit {
            it.set(
                stringPreferencesKey(note.id),
                note.text,
            )
        }
    }

    suspend fun deleteNote(id: String) {
        dataStore.edit {
            it.remove(stringPreferencesKey(id))
        }
    }
}