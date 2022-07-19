package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists.appointment.dialogs

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseDialogFragmentWithoutViewModel
import com.geektech.beauty.databinding.FragmentAppointmentVerificationSucceededDialogBinding


class AppointmentVerificationSucceededDialogFragment :
    BaseDialogFragmentWithoutViewModel<FragmentAppointmentVerificationSucceededDialogBinding>(R.layout.fragment_appointment_verification_succeeded_dialog) {
    override val binding by viewBinding(FragmentAppointmentVerificationSucceededDialogBinding::bind)
    override fun setupListeners() {
        binding.mcvOk.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}