package com.thevarungupta.recyclerviewwithmvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide
        .with(view)
        .load("http://rjtmobile.com/grocery/images/"+url)
        .into(view)
}
