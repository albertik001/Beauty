package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemWorksBinding

class WorksAdapter: RecyclerView.Adapter<WorksAdapter.WorksViewHolder>() {

    var list = ArrayList<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorksAdapter.WorksViewHolder {
        return WorksViewHolder(
            ItemWorksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WorksViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class WorksViewHolder(private val binding: ItemWorksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: String) {
            binding.imageSalon.loadImageWithGlide(it)
        }
    }

}