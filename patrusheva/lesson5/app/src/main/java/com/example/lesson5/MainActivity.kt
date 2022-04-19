package com.example.lesson5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val postAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler.adapter = postAdapter.apply {
            submitList(MockProvider.getMockPosts())
        }
    }
}