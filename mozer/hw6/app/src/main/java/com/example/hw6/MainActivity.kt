package com.example.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hw6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val noteAdapter = NoteAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.grid.apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = noteAdapter.apply {
                setOnItemClick {
                    deleteNote(it)
                    submitList(getNotes())
                }
                submitList(getNotes())
            }
            binding.fub.setOnClickListener {
                putNote(MockProvider.generateNote())
                noteAdapter.submitList(getNotes())
            }

        }
    }

    private fun getNotes(): List<Note> {
        return getSharedPreferences("prefs", MODE_PRIVATE)
            .all
            .map {
                Note(it.key, it.value.toString())
            }.sortedBy {
                it.id
            }
    }

    private fun putNote(note: Note) {
        getSharedPreferences("prefs", MODE_PRIVATE).edit {
            putString(note.id, note.text)
        }
    }

    private fun deleteNote(note: Note) {
        getSharedPreferences("prefs", MODE_PRIVATE).edit {
            remove(note.id)
        }
    }

}