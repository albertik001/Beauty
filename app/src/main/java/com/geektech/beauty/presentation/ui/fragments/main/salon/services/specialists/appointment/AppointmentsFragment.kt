package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists.appointment;

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentAppointmentsBinding
import com.geektech.beauty.presentation.ui.adapters.appointments.details.AppointmentDetailsAdapter

class AppointmentsFragment :
    BaseFragment<FragmentAppointmentsBinding, AppointmentsViewModel>(R.layout.fragment_appointments) {
    override val binding by viewBinding(FragmentAppointmentsBinding::bind)
    override val viewModel by viewModels<AppointmentsViewModel>()
    private val appointmentDetailsAdapter = AppointmentDetailsAdapter()

    override fun initialize() {
        instantiateRecycler()
    }

    private fun instantiateRecycler() {
        binding.recyclerViewAppointments.adapter = appointmentDetailsAdapter
    }

    override fun launchObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.appointmentsState.collect {
                appointmentDetailsAdapter.submitList(it)
            }
        }
    }
}