package com.example.hw6.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope

import com.example.hw6.domain.DelNotesUseCase
import com.example.hw6.domain.GetNotesUseCase
import com.example.hw6.model.Note

import kotlinx.coroutines.launch

class ListNotesViewModel(
    getNotesUseCase: GetNotesUseCase = GetNotesUseCase(),
    private val delNotesUseCase: DelNotesUseCase = DelNotesUseCase()
) : ViewModel() {

    val notesLiveData = getNotesUseCase().asLiveData()

//    fun loadNotes() = viewModelScope.launch{
////        notesLiveData.value = getNotesUseCase()
//        getNotesUseCase().collect {
//            notesLiveData.value = it
//        }
//    }

    fun deleteNotes(note:Note) = viewModelScope.launch{
        delNotesUseCase(note)
    }

}