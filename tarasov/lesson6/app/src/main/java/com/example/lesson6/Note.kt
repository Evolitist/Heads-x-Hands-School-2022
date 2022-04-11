package com.example.lesson6

data class Note(
    val id: String,
    val text: String
) {
    companion object GenerateNote {
        fun generateNote(): Note {
            val id = System.currentTimeMillis().toString()
            val text = "Some very long text, Some very long text, Some very long text! Some very long text, Some very long text, Some very long text! Some very long text, Some very long text, Some very long text!"
            return Note(id, text)
        }
    }
}


