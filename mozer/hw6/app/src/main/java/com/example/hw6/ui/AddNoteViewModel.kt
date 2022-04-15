package com.example.hw6.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw6.domain.AddNoteUseCase
import kotlinx.coroutines.launch

class AddNoteViewModel(

    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase(),

) : ViewModel() {

    val navigateLiveData = MutableLiveData<Any>()

    fun addNote(text:String) = viewModelScope.launch {
        addNoteUseCase(text)
        navigateLiveData.value = Any()
    }
}