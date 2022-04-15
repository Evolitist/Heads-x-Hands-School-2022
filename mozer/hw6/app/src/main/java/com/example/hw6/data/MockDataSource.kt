package com.example.hw6.data

import com.example.hw6.model.Note
import java.util.*
import kotlin.random.Random

object MockDataSource {
    private const val chars = "abcdefg"

    fun generateNote(text:String): Note {
        return Note(
            UUID.randomUUID().toString(), text
        )
    }
}