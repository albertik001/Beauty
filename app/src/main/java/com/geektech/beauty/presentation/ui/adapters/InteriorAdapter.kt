package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemOurInteriorsBinding
import com.geektech.beauty.presentation.models.InteriorUI

class InteriorAdapter : ListAdapter<InteriorUI, InteriorAdapter.InteriorViewHolder>(Companion) {

    inner class InteriorViewHolder(private val binding: ItemOurInteriorsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(it: InteriorUI) {
            binding.imageInteriors.loadImageWithGlide(it.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InteriorViewHolder {
        return InteriorViewHolder(
            ItemOurInteriorsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InteriorViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object : DiffUtil.ItemCallback<InteriorUI>() {
        override fun areItemsTheSame(
            oldItem: InteriorUI,
            newItem: InteriorUI
        ) = oldItem.image == newItem.image

        override fun areContentsTheSame(
            oldItem: InteriorUI,
            newItem: InteriorUI
        ) = oldItem == newItem
    }
}