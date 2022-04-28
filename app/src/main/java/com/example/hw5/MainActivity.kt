package com.example.hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = PostAdapter()
    val list = MockProvider.posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter.submitList(list)
        binding.recycler.adapter = adapter
    }


}