package com.example.hw5

import android.view.LayoutInflater
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.example.hw5.databinding.ItemPostBinding

class PostAdapter(
) : ListAdapter<Post, PostAdapter.PostViewHolder>(PostItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PostViewHolder(val viewBinding: ItemPostBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: Post) {
            viewBinding.contentText.text = item.text
            viewBinding.image.load(item.imageUrl)
        }
    }
}

//без этого recycler будет некрасивый
private object PostItemCallback : DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}