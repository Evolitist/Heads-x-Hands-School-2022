package com.example.lesson6.domain

import com.example.lesson6.data.NoteRepository
import com.example.lesson6.data.NoteRepositoryImpl

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository =
        NoteRepositoryImpl()
) {

    operator fun invoke(id: String) {
        return noteRepository.deleteNote(id)
    }
}