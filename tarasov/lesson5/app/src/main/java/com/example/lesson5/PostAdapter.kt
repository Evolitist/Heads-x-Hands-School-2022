package com.example.lesson5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lesson5.databinding.ViewContentCardBinding

class PostAdapter() : ListAdapter<Post, PostAdapter.PostViewHolder>(PostItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PostViewHolder(
            ViewContentCardBinding.inflate(inflater, parent, false)
        )

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PostViewHolder(
        private val binding: ViewContentCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Post) {
            binding.cardText.isVisible = !item.text.isNullOrBlank()
            binding.cardText.text = item.text
            binding.cardImage.load(item.imageUrl)
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