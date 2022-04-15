package com.example.hw6.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.hw6.App
import com.example.hw6.model.Note
import com.example.hw6.prefs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SharedPreferencesDataSource(
    private val dataStore: DataStore<Preferences> = App.instance.prefs
//    private val sharedPreferences: SharedPreferences =
//        App.instance.getSharedPreferences("notes", Context.MODE_PRIVATE)
) {

    fun getNotes(): Flow<List<Note>> {
        return dataStore.data
            .map { prefs ->
                prefs.asMap().map {
                    Note(it.key.name, it.value.toString())
                }.sortedByDescending {
                    it.id
                }
            }
    }
//        return sharedPreferences
//            .all
//            .map {
//                Note(it.key, it.value.toString())
//            }.sortedBy {
//                it.id
//            }


    suspend fun putNote(note: Note) {
        dataStore.edit {
            it.set(
                stringPreferencesKey(note.id),
                note.text
            )
        }
//        sharedPreferences.edit {
//            putString(note.id, note.text)
//        }
    }

    suspend fun deleteNote(note: Note) {
        dataStore.edit {
            it.remove(stringPreferencesKey(note.id))
        }
//        sharedPreferences.edit {
//            remove(note.id)
//        }
    }
}