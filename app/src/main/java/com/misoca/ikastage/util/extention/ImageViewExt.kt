package com.misoca.ikastage.util.extention

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?) {
    url ?: return
    Glide.with(this.context)
            .load(url)
            .into(this)
}

@BindingAdapter("loadImageCircle")
fun ImageView.loadImageCircle(url: String?) {
    url ?: return
    Glide.with(this.context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
}