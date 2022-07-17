package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemPopularBinding
import com.geektech.beauty.presentation.models.PopularUI

class ServicePopularAdapter :
    ListAdapter<PopularUI, ServicePopularAdapter.PopularViewHolder>(Companion) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            ItemPopularBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    inner class PopularViewHolder(private val binding: ItemPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(it: PopularUI?) {
            binding.tvNameService.text = it?.nameService
            binding.tvNameSalon.text = it?.nameSalon
            binding.imageServicePopular.loadImageWithGlide(it?.imageBanner)
            binding.tvNumberRatingBar.text = it?.countRating.toString()
        }

    }

    companion object : DiffUtil.ItemCallback<PopularUI>() {
        override fun areItemsTheSame(oldItem: PopularUI, newItem: PopularUI) =
            oldItem.nameSalon == newItem.nameSalon

        override fun areContentsTheSame(oldItem: PopularUI, newItem: PopularUI) = oldItem == newItem

    }

}
