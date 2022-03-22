package com.example.less1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
        {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = findViewById<EditText>(R.id.input)
        val output = findViewById<TextView>(R.id.output)
        val button = findViewById<Button>(R.id.button)
        }
    fun toastMe(view: View)
        {
            val input = findViewById<EditText>(R.id.input)
            val inText: String = input.getText().toString()
            // val myToast = Toast.makeText(this, message, duration);
            val myToast = Toast.makeText(this, "" + inText, Toast.LENGTH_LONG).show()
        }
}

