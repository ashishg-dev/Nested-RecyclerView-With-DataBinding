package com.devashish.nestedrecyclerview.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devashish.nestedrecyclerview.adapter.PlayerAdapter


@BindingAdapter("app:adapter")
fun setAdapter(view: RecyclerView, playerAdapter: PlayerAdapter) {
    view.adapter = playerAdapter
    view.setRecycledViewPool(RecyclerView.RecycledViewPool())
}