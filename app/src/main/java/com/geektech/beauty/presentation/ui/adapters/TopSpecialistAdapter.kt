package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemTopSpecialistBinding
import com.geektech.beauty.presentation.models.TopSpecialistUI

class TopSpecialistAdapter(private val onItemClick: () -> Unit) :
    ListAdapter<TopSpecialistUI, TopSpecialistAdapter.SpecialistViewHolder>(Companion) {
    inner class SpecialistViewHolder(private val binding: ItemTopSpecialistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(it: TopSpecialistUI?) = with(binding) {
            imageServiceCategories.loadImageWithGlide(it?.imageProfile)
            tvNameTopSpecialist.text = it?.nameMaster
            root.setOnClickListener {
                onItemClick()

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialistViewHolder {
        return SpecialistViewHolder(
            ItemTopSpecialistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SpecialistViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    companion object : DiffUtil.ItemCallback<TopSpecialistUI>() {
        override fun areItemsTheSame(oldItem: TopSpecialistUI, newItem: TopSpecialistUI) =
            oldItem.nameMaster == newItem.nameMaster

        override fun areContentsTheSame(oldItem: TopSpecialistUI, newItem: TopSpecialistUI) =
            oldItem == newItem

    }
}