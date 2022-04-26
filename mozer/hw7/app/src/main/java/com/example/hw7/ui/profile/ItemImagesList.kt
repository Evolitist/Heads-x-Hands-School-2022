package com.example.hw7.ui.profile

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import coil.load
import com.example.hw7.databinding.ItemImagesListBinding
import com.google.android.material.card.MaterialCardView

class ItemImagesList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : MaterialCardView(context, attrs, defAttrs) {

    private val _binding = ItemImagesListBinding.inflate(
        LayoutInflater.from(context),
        this,
        true)

    fun setImage(url:String){
        _binding.picture.load(url)
    }
}