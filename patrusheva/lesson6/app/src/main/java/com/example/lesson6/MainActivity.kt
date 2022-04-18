package com.example.lesson6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lesson6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.grid.apply {
            //как грид, но элементы могут быть разной высоты (или длины)
            //spanCount - количество столбцов
            //Orientation - в какую сторону будет прокручиваться сетка
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = noteAdapter.apply {
                submitList(getNotes())
            }
        }

        binding.fab.setOnClickListener{
            putNote(MockProvider.generateNote())
            noteAdapter.submitList(getNotes())
        }
    }

    private fun getNotes(): List <Note> {
        return getSharedPreferences("prefs", MODE_PRIVATE)
            .all.map {
                Note(it.key,it.value.toString())
            }.sortedByDescending { it.id }
        //prefs - как map, но живет не в оперативке а где-то там
        //map - вызывается на списке с одним типом и возвращает его с другим типом
        //пробегает по списку, на каждом элементе вызывает свою лямбду и возвращает этот элемент с другим типом
        //it - паарметр который передется в map  и это текущий элемент
        //в pref все данные хранятся в структуре map  - ключ/значение
    }

    private fun putNote(note:Note){
        getSharedPreferences("prefs", MODE_PRIVATE).edit {
            putString(note.id, note.text)
        }
    }
}