package com.example.lesson1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.input)
        val output = findViewById<TextView>(R.id.output)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val userInput = input.text
            val text = "You typed: $userInput"
            output.text = userInput

            val duration = Toast.LENGTH_SHORT
            Toast.makeText(applicationContext, text, duration).show()
        }
    }
}