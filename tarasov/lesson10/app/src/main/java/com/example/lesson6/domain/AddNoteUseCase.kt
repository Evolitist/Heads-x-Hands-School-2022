package com.example.lesson6.domain

import com.example.lesson6.data.NoteRepository
import com.example.lesson6.data.NoteRepositoryImpl

class AddNoteUseCase(
    private val noteRepository: NoteRepository =
        NoteRepositoryImpl()
) {

    suspend operator fun invoke(text: String) {
        return noteRepository.addNote(text)
    }
}