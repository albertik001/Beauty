package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemWorksOurMasterBinding
import com.geektech.beauty.presentation.models.OurSpecialistWorkUI

class OurSpecialistWorkAdapter :
    ListAdapter<OurSpecialistWorkUI, OurSpecialistWorkAdapter.MasterViewHolder>(Companion) {

    inner class MasterViewHolder(private val binding: ItemWorksOurMasterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(it: OurSpecialistWorkUI) {
            binding.imageMaster.loadImageWithGlide(it.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterViewHolder {
        return MasterViewHolder(
            ItemWorksOurMasterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object : DiffUtil.ItemCallback<OurSpecialistWorkUI>() {
        override fun areItemsTheSame(
            oldItem: OurSpecialistWorkUI,
            newItem: OurSpecialistWorkUI
        ) = oldItem.image == newItem.image

        override fun areContentsTheSame(
            oldItem: OurSpecialistWorkUI,
            newItem: OurSpecialistWorkUI
        ) = oldItem == newItem
    }
}