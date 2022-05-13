package com.example.homework_6

import android.os.SystemClock
import java.util.UUID
import kotlin.random.Random

object MockProvider {

    private const val chars = "abcdefghijklmnopqrstuvwxyz -"

    fun generateNote(): Note {
        val text = buildString {
            repeat(Random.nextInt(3, 128)) {
                append(chars.random())
            }
        }
        return Note(
            SystemClock.elapsedRealtime().toString(),
            text,
        )
    }
}
