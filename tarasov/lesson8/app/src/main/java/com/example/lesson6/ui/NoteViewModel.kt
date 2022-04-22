package com.example.lesson6.ui

import androidx.lifecycle.ViewModel
import com.example.lesson6.domain.AddNoteUseCase

class NoteViewModel(

    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase(),

) : ViewModel() {

    fun addNote(text: String = "") {
        addNoteUseCase(text)
    }
}