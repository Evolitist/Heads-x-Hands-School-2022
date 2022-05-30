package com.example.lesson6.ui

import androidx.lifecycle.*
import com.example.lesson6.domain.DeleteNoteUseCase
import com.example.lesson6.domain.GetNotesUseCase
import com.example.lesson6.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase

) : ViewModel() {

    val notesLiveData: LiveData<List<Note>> = getNotesUseCase().asLiveData()

    fun deleteNote(position: Int) = viewModelScope.launch {

        notesLiveData.value?.get(position)?.let { note ->
            deleteNoteUseCase(note.id)
        }
    }

}