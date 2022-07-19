package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.databinding.ItemButtonServicesBinding
import com.geektech.beauty.presentation.models.ButtonServicesUI

class ButtonServicesAdapter(private val onCategoryClickListener: () -> Unit) :
    ListAdapter<ButtonServicesUI, ButtonServicesAdapter.ButtonViewHolder>(Companion) {
    inner class ButtonViewHolder(private val binding: ItemButtonServicesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(it: ButtonServicesUI) {
            binding.btnService.text = it.nameServices
            binding.root.setOnClickListener {
                onCategoryClickListener()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        return ButtonViewHolder(
            ItemButtonServicesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object : DiffUtil.ItemCallback<ButtonServicesUI>() {
        override fun areItemsTheSame(
            oldItem: ButtonServicesUI,
            newItem: ButtonServicesUI
        ) = oldItem.nameServices == newItem.nameServices

        override fun areContentsTheSame(
            oldItem: ButtonServicesUI,
            newItem: ButtonServicesUI
        ) = oldItem == newItem
    }
}