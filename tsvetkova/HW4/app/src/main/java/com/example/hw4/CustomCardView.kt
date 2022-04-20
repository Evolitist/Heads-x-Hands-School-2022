package com.example.hw4

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import com.example.hw4.databinding.CardViewBinding

//@JvmOverloads constructor
class CustomCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defattrs: Int = 0
) : FrameLayout(context, attrs, defattrs) {

    private lateinit var binding: CardViewBinding

    init {
        binding =  CardViewBinding.inflate(LayoutInflater.from(context),this,true)
    }


    fun addImage(@DrawableRes id: Int) {
        binding.image.setImageResource(id)
    }
}