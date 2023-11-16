package com.example.marvieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvieapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUp()


    }


    private fun getListItems(): List<Item> {
        return listOf(
            Item(1, R.drawable.model__1, "Blazer", "$120", "\uD83C\uDF89  Party"),
            Item(1, R.drawable.model__2, "Hoodie with shorts", "$500", "Category 1"),
            Item(1, R.drawable.model__3, "Hoodie with skirt", "$180", "Category 3"),
            Item(1, R.drawable.model__4, "Hoodie with trousers", "$56", "Category 2"),
            Item(1, R.drawable.model__2, "Denim", "$986", "\uD83C\uDFD6️ Beach"),
            Item(1, R.drawable.model__1, "Shorts", "$177", "Category 3"),
            Item(1, R.drawable.model__3, "T-shirt", "$612", "\uD83C\uDFD6️ Beach"),
            Item(1, R.drawable.model__3, "Jumpsuit", "$123", "Blazerr"),
            Item(1, R.drawable.model__1, "Dress", "$247", "\uD83C\uDFD6️ Beach"),
            Item(1, R.drawable.model__2, "Blazer", "$256", "Category 1"),
            Item(1, R.drawable.model__3, "Denim", "$301", "Category 3"),
            Item(1, R.drawable.model__1, "Top", "$933", "Category 1"),
            Item(1, R.drawable.model__2, "Tank top", "$201", "\uD83C\uDFD5 Camping"),
            Item(1, R.drawable.model__4, "Coat", "$971", "\uD83C\uDF89  Party"),
            Item(1, R.drawable.model__3, "Sweeter", "$356", "\uD83C\uDFD5 Camping"),

            )
    }

    private fun getList(): List<Category> {
        return listOf(
            Category(CategoryAdapter.ALL_BUTTON, 1, "All"),
            Category(CategoryAdapter.OTHER_BUTTON, 2, "\uD83C\uDF89  Party"),
            Category(CategoryAdapter.OTHER_BUTTON, 3, "\uD83C\uDFD5 Camping"),
            Category(CategoryAdapter.OTHER_BUTTON, 3, "\uD83C\uDFD6️ Beach"),
            Category(CategoryAdapter.OTHER_BUTTON, 4, "Category 1"),
            Category(CategoryAdapter.OTHER_BUTTON, 5, "Category 2"),
            Category(CategoryAdapter.OTHER_BUTTON, 6, "Category 3")
        )
    }


    private fun setUp() {
        categoryAdapter = CategoryAdapter { selectedCategory ->
            when (selectedCategory.name) {
                "All" -> itemAdapter.submitList(getListItems())
                else -> {
                    val categoryItems =
                        getListItems().filter { it.categoryType == selectedCategory.name }
                    itemAdapter.submitList(categoryItems)
                }
            }
        }
        categoryAdapter.submitList(getList())

        itemAdapter = ItemAdapter()
        binding.recyclerViewItems.adapter = itemAdapter




        itemAdapter.submitList(getListItems())
        binding.recyclerViewCategories.adapter = categoryAdapter

    }


}