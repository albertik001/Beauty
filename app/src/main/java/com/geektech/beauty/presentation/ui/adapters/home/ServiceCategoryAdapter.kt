package com.geektech.beauty.presentation.ui.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.base.BaseDiffUtil
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemCategoriesBinding
import com.geektech.beauty.presentation.models.CategoryUI

class ServiceCategoryAdapter() :
    ListAdapter<CategoryUI, ServiceCategoryAdapter.CategoryViewHolder>(BaseDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CategoryViewHolder(private val binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(it: CategoryUI) {
            binding.imageServiceCategories.loadImageWithGlide(it.imageBanner)
            binding.tvNameService.text = it.nameService
        }

    }
}