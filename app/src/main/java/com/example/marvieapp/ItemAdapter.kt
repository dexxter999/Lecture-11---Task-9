package com.example.marvieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvieapp.databinding.ItemRecyclerBinding

class ItemAdapter() : ListAdapter<Item, ItemAdapter.ItemViewHolder>(ItemDiffCallback()) {

     class ItemViewHolder(private val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                model.setImageResource(item.image)
                tvNameOfOutfit.text = item.title
                tvPrice.text = item.price.toString()
            }
        }

         companion object {
             fun create(parent: ViewGroup): ItemViewHolder {
                 val binding = ItemRecyclerBinding.inflate(
                     LayoutInflater.from(parent.context),
                     parent,
                     false
                 )
                 return ItemViewHolder(binding)
             }
         }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}