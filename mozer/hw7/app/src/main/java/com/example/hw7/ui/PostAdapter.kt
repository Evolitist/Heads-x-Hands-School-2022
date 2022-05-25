package com.example.hw7.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hw7.model.Post
import com.example.hw7.databinding.CardViewBinding

class PostAdapter : ListAdapter<Post, PostAdapter.PostViewHolder>(PostItemCallback) {

    private var onItemClick: ((Post) -> Unit)? = null

    fun setOnItemClick(callback: (Post) -> Unit) {
        onItemClick = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return PostViewHolder(
            CardViewBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostViewHolder(
        private val binding: CardViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Post) {
            binding.cardText.isVisible = !item.text.isNullOrBlank()
            binding.cardText.text = item.text

            binding.picture.isVisible = !item.imageURL.isNullOrBlank()
            if (binding.picture.isVisible) {
                binding.cardText.maxLines = 4
            }
            binding.picture.load(item.imageURL)

            binding.root.setOnClickListener {
                onItemClick?.invoke(item)
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