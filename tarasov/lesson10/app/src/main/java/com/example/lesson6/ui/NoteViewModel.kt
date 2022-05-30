package com.example.lesson6.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson6.domain.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(

    private val addNoteUseCase: AddNoteUseCase,

) : ViewModel() {

    fun addNote(text: String, callback: () -> Unit) = viewModelScope.launch{
        addNoteUseCase(text)
        callback()
    }
}