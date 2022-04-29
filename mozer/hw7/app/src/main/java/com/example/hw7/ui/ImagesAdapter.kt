package com.example.hw7.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hw7.databinding.ItemImagesListBinding
import com.example.hw7.domain.model.Image

class ImagesAdapter : ListAdapter<Image, ImagesAdapter.ImagesViewHolder>(ImagesItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ImagesViewHolder(
            ItemImagesListBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImagesViewHolder(

        private val binding: ItemImagesListBinding

    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Image) {
            binding.picture.isVisible = !item.sizes.isEmpty()
            binding.picture.load(item.sizes.last().url)

        }

    }

    private object ImagesItemCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

    }


}