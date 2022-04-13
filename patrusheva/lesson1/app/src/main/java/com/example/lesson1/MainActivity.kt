package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val typedText = binding.input.text
            binding.output.text = typedText
            Toast.makeText(this, "\"$typedText\" was typed", Toast.LENGTH_SHORT).show()
            binding.input.setText("")
        }
    }
}