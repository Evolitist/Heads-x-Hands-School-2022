package com.example.lesson6.domain

import com.example.lesson6.data.NoteRepositoryImpl
import com.example.lesson6.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(

    private val noteRepository: NoteRepositoryImpl

) {

    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getNotes()
    }
}