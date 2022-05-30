package com.example.lesson6.domain

import com.example.lesson6.data.NoteRepositoryImpl
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(

    private val noteRepository: NoteRepositoryImpl

) {

    suspend operator fun invoke(text: String) {
        return noteRepository.addNote(text)
    }
}