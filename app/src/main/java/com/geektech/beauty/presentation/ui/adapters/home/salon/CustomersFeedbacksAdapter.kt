package com.geektech.beauty.presentation.ui.adapters.home.salon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.core.extensions.setImage
import com.geektech.beauty.databinding.ItemFeedbackBinding
import com.geektech.beauty.presentation.models.CustomerFeedbackUI

class CustomersFeedbacksAdapter :
    ListAdapter<CustomerFeedbackUI, CustomersFeedbacksAdapter.CustomerFeedbacksViewHolder>(Companion) {


    companion object : DiffUtil.ItemCallback<CustomerFeedbackUI>() {
        override fun areItemsTheSame(
            oldItem: CustomerFeedbackUI,
            newItem: CustomerFeedbackUI
        ) = oldItem.customerName == newItem.customerName


        override fun areContentsTheSame(
            oldItem: CustomerFeedbackUI,
            newItem: CustomerFeedbackUI
        ) = oldItem == newItem


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CustomerFeedbacksViewHolder(
        ItemFeedbackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: CustomerFeedbacksViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class CustomerFeedbacksViewHolder(private val binding: ItemFeedbackBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(customerFeedback: CustomerFeedbackUI) = with(binding) {
            imageProfileMaster.setImage(customerFeedback.customerImage)
            tvNameMaster.text = customerFeedback.customerName
            tvTextFeedback.text = customerFeedback.feedback
            ratingBarMaster.rating = customerFeedback.rating.toFloat()

        }

    }
}