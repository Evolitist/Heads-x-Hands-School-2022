package com.example.lesson6.ui

import androidx.lifecycle.*
import com.example.lesson6.domain.DeleteNoteUseCase
import com.example.lesson6.domain.GetNotesUseCase
import com.example.lesson6.model.Note
import kotlinx.coroutines.launch

class MainViewModel(

    private val getNotesUseCase: GetNotesUseCase = GetNotesUseCase(),
    private val deleteNoteUseCase: DeleteNoteUseCase = DeleteNoteUseCase()

) : ViewModel() {

    val notesLiveData: LiveData<List<Note>> = getNotesUseCase().asLiveData()

    fun deleteNote(position: Int) = viewModelScope.launch {
//        val mutableList = notesLiveData.value?.toMutableList()
//        mutableList?.removeAt(position)
//        notesLiveData.value = mutableList.orEmpty()
        notesLiveData.value?.get(position)?.let { note ->
            deleteNoteUseCase(note.id)
        }
    }

}