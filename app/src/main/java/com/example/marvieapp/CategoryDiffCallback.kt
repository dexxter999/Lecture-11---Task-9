package com.example.marvieapp

import androidx.recyclerview.widget.DiffUtil

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem

}