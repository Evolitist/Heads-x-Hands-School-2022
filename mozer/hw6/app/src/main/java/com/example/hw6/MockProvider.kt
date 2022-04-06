package com.example.hw6

import java.util.*
import kotlin.random.Random

object MockProvider {
    private const val chars = "abcdefg"

    fun generateNote(): Note {
        val text =
            buildString {
                repeat(Random.nextInt(3, 120)) {
                    append(chars.random())
                }
            }
        return Note(
            UUID.randomUUID().toString(), text
        )
    }
}