package com.example.homework_5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.homework_5.databinding.ViewContentCardBinding

class PostAdapter() : ListAdapter<Post, PostAdapter.PostViewHolder>(PostItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ViewContentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PostViewHolder(
        private val binding: ViewContentCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.cardText.text = item.titleText
            binding.text.text = item.text
            binding.cardImage.load(item.imageUrl)
            if(item.text == null){
                binding.text.isVisible = false
            }
            if(item.imageUrl == null){
                binding.cardImage.isVisible = false
            }
        }
    }

    private object PostItemCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}