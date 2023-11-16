package com.example.marvieapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvieapp.databinding.ItemCategoryAllBinding
import com.example.marvieapp.databinding.ItemCategoryBinding

class CategoryAdapter (
    private val onCategoryClick: (Category) -> Unit
) : ListAdapter<Category, RecyclerView.ViewHolder>(CategoryDiffCallback()) {

    companion object {
        const val ALL_BUTTON = 1
        const val OTHER_BUTTON = 2
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.buttonCategory.text = category.name
            binding.buttonCategory.setOnClickListener {
                onCategoryClick.invoke(category)
            }
        }
    }

    inner class AllCategoryViewHolder(private val binding: ItemCategoryAllBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.buttonCategoryAll.text = category.name
            binding.buttonCategoryAll.setOnClickListener {
                onCategoryClick.invoke(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ALL_BUTTON -> {
                AllCategoryViewHolder(ItemCategoryAllBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }

            OTHER_BUTTON -> CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("invalid argument")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (currentList[position].viewType) {
            ALL_BUTTON -> (holder as AllCategoryViewHolder).bind(currentList[position])
            OTHER_BUTTON -> (holder as CategoryViewHolder).bind(currentList[position])
            else -> throw IllegalArgumentException("invalid argument")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].viewType
    }

}


