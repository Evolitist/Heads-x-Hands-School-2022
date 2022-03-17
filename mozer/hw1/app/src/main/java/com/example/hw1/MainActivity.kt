package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val textInput = findViewById<EditText>(R.id.input).text
            findViewById<TextView>(R.id.output).text = textInput
            Toast.makeText(this, "You typed: $textInput", Toast.LENGTH_SHORT).show()
        }
    }
}