package com.jgeun.aftest.common_ui.util

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jgeun.aftest.common_ui.result.UiState

@BindingAdapter("showProgressBar")
fun ProgressBar.bindShow(result: UiState<*>?) {
    visibility = if (result is UiState.Loading || result == null) View.VISIBLE else View.GONE
}

@BindingAdapter("loadImage")
fun AppCompatImageView.bindImage(url: String) {
    if (url.isEmpty()) return

    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

@BindingAdapter("rvItemDecoration")
fun RecyclerView.bindItemDecoration(itemDecoration: RecyclerView.ItemDecoration) {
    this.addItemDecoration(itemDecoration)
}

@BindingAdapter("rvItemFixedSizeOption")
fun RecyclerView.bindFixedSizeOption(option: Boolean) {
    this.setHasFixedSize(option)
}

@BindingAdapter("rvScrollListener")
fun RecyclerView.bindScrollListener(scrollListener: OnScrollListener) {
    this.addOnScrollListener(scrollListener)
}