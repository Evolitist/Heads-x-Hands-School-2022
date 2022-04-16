package com.example.hw6.ui

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw6.domain.AddNoteUseCase
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class AddNoteViewModel(

    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase(),

) : ViewModel() {

    val navigateLiveData = MutableLiveData<Any>()
    val snackLiveData = MutableLiveData<Any>()

    fun addNote(text:String) = viewModelScope.launch {
        if (text.isBlank()){
            snackLiveData.value = Any()
        }
        else{
            addNoteUseCase(text)
            navigateLiveData.value = Any()
        }
    }
}