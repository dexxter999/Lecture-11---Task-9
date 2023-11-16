package com.example.marvieapp

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem

}