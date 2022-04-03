package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//        val linearLayout = findViewById<LinearLayout>(R.id.cards)
//
//        repeat(4){
//            createCard((linearLayout))
//        }

//    fun createCard (linearLayout: LinearLayout){
//        val card = layoutInflater.inflate(R.layout.card_view, linearLayout, true)
//    }
