package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists.appointment

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.databinding.FragmentVerifyAppointmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random


@AndroidEntryPoint
class VerifyAppointmentFragment :
    BaseFragment<FragmentVerifyAppointmentBinding, VerifyAppointmentViewModel>(R.layout.fragment_verify_appointment) {
    override val binding by viewBinding(FragmentVerifyAppointmentBinding::bind)
    override val viewModel by viewModels<VerifyAppointmentViewModel>()
    override fun performListeners() {
        verifyAnAppointment()
    }

    private fun verifyAnAppointment() {
        binding.btnVerifyTheAppointment.setOnClickListener {
            when (Random.nextBoolean()) {
                true -> findNavController().navigateSafely(R.id.action_verifyAppointmentFragment_to_appointmentVerificationDialogFragment)
                else -> findNavController().navigateSafely(R.id.action_verifyAppointmentFragment_to_appointmentVerificationFailedDialogFragment)
            }
        }
    }

}