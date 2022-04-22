package com.example.lesson6.domain

import com.example.lesson6.data.NoteRepository
import com.example.lesson6.data.NoteRepositoryImpl
import com.example.lesson6.model.Note

class GetNotesUseCase(
    private val noteRepository: NoteRepository =
        NoteRepositoryImpl()
) {

    operator fun invoke(): List<Note> {
        return noteRepository.getNotes()
    }
}