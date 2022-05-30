package com.example.lesson6.domain

import com.example.lesson6.data.NoteRepositoryImpl
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(

    private val noteRepository: NoteRepositoryImpl

) {
    suspend operator fun invoke(id: Int) {
        return noteRepository.deleteNote(id)
    }
}