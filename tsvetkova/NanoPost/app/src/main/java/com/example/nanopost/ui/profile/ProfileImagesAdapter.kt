package com.example.nanopost.ui.profile


import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.nanopost.databinding.ItemImageProfileBinding
import com.example.nanopost.domain.model.Image

class ProfileImagesAdapter() :
    ListAdapter<Image, ProfileImagesAdapter.ImageViewHolder>(ImageItemCallBack) {

    private lateinit var onImageClick: (Image) -> Unit

    fun setOnImageClick(callback: (Image) -> Unit) {
        onImageClick = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val viewBinding =
            ItemImageProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImageViewHolder(private val viewBinding: ItemImageProfileBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: Image) {
            viewBinding.image.apply {
                load(item.sizes.last().url)
                setOnClickListener {
                    onImageClick(item)
                }
            }

        }
    }

}

private object ImageItemCallBack : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}