package com.example.less3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.withStyledAttributes
import com.example.less3.databinding.ItemCardBinding
import com.example.less3.databinding.ViewContentCardBinding
import com.google.android.material.card.MaterialCardView

class ContentCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
): MaterialCardView(context, attrs,defStyleAttr){

    private val binding = ViewContentCardBinding.inflate(LayoutInflater.from(context), this)

    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.ContentCardView,
            defStyleAttr,
        ){
            binding.cardText.text = getString(R.styleable.ContentCardView_subtitle) ?: "Card with content"
            binding.cardTitle.text = getString(R.styleable.ContentCardView_title) ?: "Content description"
            binding.shapeableImageView.setImageDrawable(getDrawable(R.styleable.ContentCardView_image))
            binding.materialButton.text = getString(R.styleable.ContentCardView_buttonText) ?: ""
        }
    }


}