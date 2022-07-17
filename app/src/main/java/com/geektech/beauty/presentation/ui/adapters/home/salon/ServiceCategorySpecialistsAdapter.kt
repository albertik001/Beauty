package com.geektech.beauty.presentation.ui.adapters.home.salon

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.presentation.models.ServiceCategorySpecialistUI

class ServiceCategorySpecialistsAdapter :
    ListAdapter<ServiceCategorySpecialistUI, ServiceCategorySpecialistsAdapter.ServiceCategorySpecialistsViewHolder>(
        Companion
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ServiceCategorySpecialistsViewHolder()


    override fun onBindViewHolder(holder: ServiceCategorySpecialistsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class ServiceCategorySpecialistsViewHolder() : RecyclerView.ViewHolder(binding.root) {
        fun onBind(specialist: ServiceCategorySpecialistUI) {

        }

    }

    companion object : DiffUtil.ItemCallback<ServiceCategorySpecialistUI>() {
        override fun areItemsTheSame(
            oldItem: ServiceCategorySpecialistUI,
            newItem: ServiceCategorySpecialistUI
        ) = oldItem.specialistImage == newItem.specialistImage


        override fun areContentsTheSame(
            oldItem: ServiceCategorySpecialistUI,
            newItem: ServiceCategorySpecialistUI
        ) = oldItem == newItem


    }


}