package com.example.homework_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.homework_6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.grid.apply{
            layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
            adapter = noteAdapter.apply {
                submitList(getNote())
            }
        }
        binding.fab.setOnClickListener{
            putNote(MockProvider.generateNote())
            noteAdapter.submitList(getNote())
        }
    }
    fun getNote():List<Note>{
        return getSharedPreferences("prefs", MODE_PRIVATE).all.map {
            Note(it.key,it.value.toString())
        }.sortedBy {
            it.id
        }
    }

    fun putNote(note: Note){
        getSharedPreferences("prefs", MODE_PRIVATE).edit {
            putString(note.id,note.text)
        }
    }
}