package com.example.lesson6.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson6.domain.AddNoteUseCase
import com.example.lesson6.domain.DeleteNoteUseCase
import com.example.lesson6.domain.GetNotesUseCase
import com.example.lesson6.model.Note

class MainViewModel(

    private val getNotesUseCase: GetNotesUseCase = GetNotesUseCase(),
    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase(),
    private val deleteNoteUseCase: DeleteNoteUseCase = DeleteNoteUseCase()

) : ViewModel() {

    val notesLiveData = MutableLiveData<List<Note>>()

    fun loadNotes() {
        notesLiveData.value = getNotesUseCase()
    }

    fun addNote(text: String = "") {
        addNoteUseCase(text)
        loadNotes()
    }

    fun deleteNote(position: Int) {
        val mutableList = notesLiveData.value?.toMutableList()
        mutableList?.removeAt(position)
        notesLiveData.value = mutableList.orEmpty()
    }

}