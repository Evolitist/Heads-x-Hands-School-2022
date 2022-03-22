package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.input)
        val output = findViewById<TextView>(R.id.output)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            output.setText(input.text)
            Toast.makeText(this, "You typed: ${input.text}" , Toast.LENGTH_LONG).show()
        }
    }
}