package com.geektech.beauty.presentation.ui.adapters.appointments.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.beauty.databinding.ItemAppointmentsBinding
import com.geektech.beauty.presentation.models.AppointmentDetailsUI

class AppointmentDetailsAdapter :
    ListAdapter<AppointmentDetailsUI, AppointmentDetailsAdapter.AppointmentViewHolder>(Companion) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        return AppointmentViewHolder(
            ItemAppointmentsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class AppointmentViewHolder(private val binding: ItemAppointmentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(it: AppointmentDetailsUI) {
            binding.tvAddressMail.text = it.salonInformationUI.addressSalon
            binding.tvPhoneNumbers.text = it.salonInformationUI.phoneNumber
            binding.tvTimeWork.text = it.salonInformationUI.workTime
            binding.tvOperationMode.text = it.salonInformationUI.workMode
            binding.tvLocationAddress.text = it.salonInformationUI.addressSalon

            binding.tvDateOfAppointments.text = it.dateOfAppointments
            binding.tvTimeAppointments.text = it.timeOfWork
            binding.tvServiceContent.text = it.service
            binding.tvDurationContent.text = it.duration
            binding.tvMasterContent.text = it.specialist
            binding.tvServiceCostContent.text = it.serviceCost
        }

    }

    companion object : DiffUtil.ItemCallback<AppointmentDetailsUI>() {
        override fun areItemsTheSame(
            oldItem: AppointmentDetailsUI,
            newItem: AppointmentDetailsUI
        ) = oldItem.timeOfWork == newItem.timeOfWork

        override fun areContentsTheSame(
            oldItem: AppointmentDetailsUI,
            newItem: AppointmentDetailsUI
        ) = oldItem == newItem


    }

}