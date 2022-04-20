package com.example.hw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cat1.addImage(R.drawable.cat1)
        binding.cat2.addImage(R.drawable.cat2)
        binding.cat3.addImage(R.drawable.cat3)
        binding.cat4.addImage(R.drawable.cat4)
    }
}
