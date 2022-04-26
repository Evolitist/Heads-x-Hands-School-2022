package com.example.less3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.less3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }
}