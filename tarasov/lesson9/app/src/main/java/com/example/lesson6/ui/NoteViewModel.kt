package com.example.lesson6.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson6.domain.AddNoteUseCase
import kotlinx.coroutines.launch

class NoteViewModel(

    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase(),

) : ViewModel() {

    fun addNote(text: String, callback: () -> Unit) = viewModelScope.launch{
        addNoteUseCase(text)
        callback()
    }
}