package com.voidx.jsonplaceholder.view.widget.imageview.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.voidx.jsonplaceholder.R
import com.voidx.jsonplaceholder.view.util.CropCircleTransformation

object BindableImageView {

    @BindingAdapter("circle_url")
    @JvmStatic
    fun loadImageCircleUrl(imageView: ImageView, url: String?) {
        if(url.isNullOrBlank()) {
            imageView.setImageResource(R.drawable.circle_placeholder)
            return
        }

        Picasso
            .get()
            .load(url)
            .transform(CropCircleTransformation())
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

        Picasso
            .get()
            .load(url)
            .placeholder(R.drawable.square_placeholder)
            .into(imageView)
    }

}