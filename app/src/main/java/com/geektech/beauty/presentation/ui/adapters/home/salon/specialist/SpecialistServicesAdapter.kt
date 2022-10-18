package com.geektech.beauty.presentation.ui.adapters.home.salon.specialist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.databinding.ItemSpecialistServiceCategoriesBinding
import com.geektech.beauty.presentation.models.SpecialistServiceUI

class SpecialistServicesAdapter :
    ListAdapter<SpecialistServiceUI, SpecialistServicesAdapter.SpecialistServicesViewHolder>(
        Companion
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = SpecialistServicesViewHolder(
        ItemSpecialistServiceCategoriesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )


    override fun onBindViewHolder(holder: SpecialistServicesViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class SpecialistServicesViewHolder(private val binding: ItemSpecialistServiceCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(specialistService: SpecialistServiceUI) = with(binding) {
            tvServiceName.text = specialistService.service
            tvServiceCost.text =
                "${specialistService.serviceCost} сом- "
            tvServiceTime.text = "${specialistService.serviceTime} час"

        }


    }

    companion object : DiffUtil.ItemCallback<SpecialistServiceUI>() {
        override fun areItemsTheSame(
            oldItem: SpecialistServiceUI,
            newItem: SpecialistServiceUI
        ) = oldItem.service == newItem.service


        override fun areContentsTheSame(
            oldItem: SpecialistServiceUI,
            newItem: SpecialistServiceUI
        ) = oldItem == newItem


    }


}