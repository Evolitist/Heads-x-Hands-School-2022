package com.example.lesson3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.withStyledAttributes
import com.example.lesson3.databinding.ViewContentCardBinding.inflate
import com.google.android.material.card.MaterialCardView

class ContentCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val binding = inflate(LayoutInflater.from(context), this)

    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.ContentCardView,
            defStyleAttr,
        ) {
            binding.cardText.text = getString(R.styleable.ContentCardView_subtitle)
            binding.cardTitle.text = getString(R.styleable.ContentCardView_title)
            binding.cardImage.setImageDrawable(getDrawable(R.styleable.ContentCardView_image))
            binding.cardActionButton.text = getString(R.styleable.ContentCardView_buttonText)
        }
    }
}