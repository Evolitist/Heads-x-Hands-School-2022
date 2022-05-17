package com.example.lesson6.domain

import com.example.lesson6.data.NoteRepository
import com.example.lesson6.data.NoteRepositoryImpl
import com.example.lesson6.model.Note
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(
    private val noteRepository: NoteRepository =
        NoteRepositoryImpl()
) {

    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getNotes()
    }
}