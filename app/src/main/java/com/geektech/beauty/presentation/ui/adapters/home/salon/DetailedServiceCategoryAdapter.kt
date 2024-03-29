package com.geektech.beauty.presentation.ui.adapters.home.salon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemServicesBinding
import com.geektech.beauty.presentation.models.DetailedCategoryUI

class DetailedServiceCategoryAdapter(val onItemClick: () -> Unit) :
    ListAdapter<DetailedCategoryUI, DetailedServiceCategoryAdapter.DetailedServiceCategoryViewHolder>(
        Companion
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailedServiceCategoryViewHolder(
            ItemServicesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: DetailedServiceCategoryViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class DetailedServiceCategoryViewHolder(private val binding: ItemServicesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(detailCategory: DetailedCategoryUI) {
            binding.apply {
                imService.loadImageWithGlide(detailCategory.serviceImage)
                tvServiceType.text = detailCategory.serviceType
                tvServiceTime.text = "Время: ${detailCategory.serviceTime}"
                tvServiceCost.text = "Стоимость: ${detailCategory.serviceCost}"
                root.setOnClickListener {
                    onItemClick()
                }
            }
        }

    }

    companion object : DiffUtil.ItemCallback<DetailedCategoryUI>() {
        override fun areItemsTheSame(
            oldItem: DetailedCategoryUI,
            newItem: DetailedCategoryUI
        ) = oldItem.serviceType == newItem.serviceType

        override fun areContentsTheSame(
            oldItem: DetailedCategoryUI,
            newItem: DetailedCategoryUI
        ) = oldItem == newItem


    }


}