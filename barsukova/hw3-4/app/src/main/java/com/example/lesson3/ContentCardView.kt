package com.example.lesson3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.withStyledAttributes
import com.example.lesson3.databinding.ContentCardViewBinding
import com.google.android.material.card.MaterialCardView


class ContentCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val binding = ContentCardViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.ContentCardView,
            defStyleAttr
        ) {
            binding.cardContent.text = getString(R.styleable.ContentCardView_title)
            binding.cardDescription.text = getString(R.styleable.ContentCardView_subtitle)
            binding.cardImage.setImageDrawable(getDrawable(R.styleable.ContentCardView_image))
            binding.cardButton.text = getString(R.styleable.ContentCardView_buttonText)
        }
    }


}