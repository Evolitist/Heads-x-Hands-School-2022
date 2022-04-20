package com.example.lesson5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lesson5.databinding.ItemPostBinding

class PostAdapter: ListAdapter<Post, PostAdapter.PostViewHolder> (PostItemCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater,parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PostViewHolder (
        private val binding: ItemPostBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind (item: Post) {
            binding.cardText.text = item.text
            binding.cardImage.load(item.imageUrl)
            //предусмотреть случаи, когда imageUrl и text == null (скрыть view в этом случае)
            binding.cardText.isVisible = !item.text.isNullOrBlank()
            binding.cardImage.isVisible = !item.imageUrl.isNullOrBlank()
            //blank в т.ч. учитывает строку с одними пробелами
        }
    }

    private object PostItemCallBack: DiffUtil.ItemCallback<Post>() {

        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}