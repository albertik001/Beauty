package com.geektech.beauty.presentation.ui.adapters.home.salon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemSpecialistBinding
import com.geektech.beauty.presentation.models.ServiceCategorySpecialistUI

class ServiceCategorySpecialistsAdapter(val onItemClick: (position: Int) -> Unit) :
    ListAdapter<ServiceCategorySpecialistUI, ServiceCategorySpecialistsAdapter.ServiceCategorySpecialistsViewHolder>(
        Companion
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ServiceCategorySpecialistsViewHolder(
        ItemSpecialistBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
    )


    override fun onBindViewHolder(holder: ServiceCategorySpecialistsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class ServiceCategorySpecialistsViewHolder(private val binding: ItemSpecialistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(specialist: ServiceCategorySpecialistUI) {
            binding.apply {
                tvSpecialistMastery.text = specialist.mastery
                imSpecialist.loadImageWithGlide(specialist.specialistImage)
                tvSpecialistNameAndMastery.text = specialist.nameAndMasteryType
                tvSpecialistExperience.text = "Стаж ${specialist.yearsOfExperience} лет"
                tvSpecialistRating.text = specialist.rating.toString()
                ratingBarSpecialist.rating = specialist.rating.toFloat()
                root.setOnClickListener {
                    onItemClick(absoluteAdapterPosition)
                }
            }

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