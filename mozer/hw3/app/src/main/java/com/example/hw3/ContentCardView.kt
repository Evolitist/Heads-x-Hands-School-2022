package com.example.hw3

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.hw3.databinding.CardViewBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView

class ContentCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defAttrs: Int = 0,
) : MaterialCardView(context, attrs, defAttrs) {

    private val _binding = CardViewBinding.inflate(
        LayoutInflater.from(context),
        this,
        true)

    fun setImage(id:Int){
        _binding.picture.setImageResource(id)
    }
}