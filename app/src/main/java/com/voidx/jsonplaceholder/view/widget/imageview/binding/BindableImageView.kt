package com.voidx.jsonplaceholder.view.widget.imageview.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.voidx.jsonplaceholder.R

object BindableImageView {

    @BindingAdapter("circle_url")
    @JvmStatic
    fun loadImageCircleUrl(imageView: ImageView, url: String?) {
        if(url.isNullOrBlank()) {
            imageView.setImageResource(R.drawable.circle_placeholder)
            return
        }

        Glide
            .with(imageView)
            .load(url)
            .placeholder(R.drawable.circle_placeholder)
            .into(imageView)
    }

    @BindingAdapter("url")
    @JvmStatic
    fun loadImageUrl(imageView: ImageView, url: String?) {
        if(url.isNullOrBlank()) {
            imageView.setImageResource(R.drawable.square_placeholder)
            return
        }

        Glide
            .with(imageView)
            .load(url)
            .placeholder(R.drawable.square_placeholder)
            .into(imageView)
    }

}