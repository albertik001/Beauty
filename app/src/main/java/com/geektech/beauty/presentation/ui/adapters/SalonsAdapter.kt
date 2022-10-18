package com.geektech.beauty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.loadImageWithGlide
import com.geektech.beauty.databinding.ItemSalonsBinding
import com.geektech.beauty.presentation.models.SalonsUI
import com.geektech.beauty.presentation.ui.adapters.SalonsAdapter.SalonsViewHolder

class SalonsAdapter : ListAdapter<SalonsUI, SalonsViewHolder>(Companion) {

    private val adapterWorks: WorksAdapter by lazy {
        WorksAdapter()
    }
    var onClick: ((salons: SalonsUI) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SalonsAdapter.SalonsViewHolder {
        return SalonsViewHolder(
            ItemSalonsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SalonsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class SalonsViewHolder(private val binding: ItemSalonsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: SalonsUI) {
            binding.tvNumberRatingBar.text = it.countRating.toString()
            binding.imageSalonLogo.loadImageWithGlide(it.imageLogo)
            binding.ratingBarSalon.rating = it.countRating.toFloat()
            binding.tvSalonName.text = it.nameSalon
            adapterWorks.list = it.listImageWorks as ArrayList<String>
            binding.rvWorks.adapter = adapterWorks

            itemView.setOnClickListener {
                onClick?.invoke(getItem(absoluteAdapterPosition))
            }
        }
    }

    companion object : DiffUtil.ItemCallback<SalonsUI>() {
        override fun areItemsTheSame(oldItem: SalonsUI, newItem: SalonsUI) =
            oldItem.nameSalon == newItem.nameSalon

        override fun areContentsTheSame(oldItem: SalonsUI, newItem: SalonsUI) = oldItem == newItem
    }

}