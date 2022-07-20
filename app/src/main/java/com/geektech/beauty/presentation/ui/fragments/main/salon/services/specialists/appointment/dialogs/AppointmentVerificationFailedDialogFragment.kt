package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists.appointment.dialogs

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseDialogFragmentWithoutViewModel
import com.geektech.beauty.databinding.FragmentAppointmentVerificationFailedDialogBinding


class AppointmentVerificationFailedDialogFragment :
    BaseDialogFragmentWithoutViewModel<FragmentAppointmentVerificationFailedDialogBinding>(R.layout.fragment_appointment_verification_failed_dialog) {
    override val binding by viewBinding(FragmentAppointmentVerificationFailedDialogBinding::bind)
    override fun setupListeners() {
        binding.mcvBackToAppointments.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}