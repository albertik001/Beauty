package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists.profile

import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentSpecialistProfileBinding
import com.geektech.beauty.presentation.ui.adapters.home.salon.CustomersFeedbacksAdapter
import com.geektech.beauty.presentation.ui.adapters.home.salon.specialist.SpecialistServicesAdapter


class SpecialistProfileFragment :
    BaseFragment<FragmentSpecialistProfileBinding, SpecialistProfileViewModel>(R.layout.fragment_specialist_profile) {
    override val binding by viewBinding(FragmentSpecialistProfileBinding::bind)
    override val viewModel by viewModels<SpecialistProfileViewModel>()
    private val specialistServicesAdapter = SpecialistServicesAdapter()
    private val customersFeedbacksAdapter = CustomersFeedbacksAdapter()
    override fun initialize() {
        constructServicesCategoriesRecycler()
        constructCustomersFeedbacksRecycler()
    }


    private fun constructServicesCategoriesRecycler() {
        binding.rvServiceCategories.adapter = specialistServicesAdapter
    }

    private fun constructCustomersFeedbacksRecycler() {
        binding.rvCustomersFeedbacks.adapter = customersFeedbacksAdapter
    }

    override fun constructViews() {
        binding.tvSpecialistDescription.movementMethod = ScrollingMovementMethod.getInstance()
    }

    override fun launchObservers() {
        subscribeToSpecialistServices()
        subscribeToCustomersFeedbacks()
    }


    private fun subscribeToSpecialistServices() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.specialistServicesState.collect {
                specialistServicesAdapter.submitList(it)

            }
        }
    }

    private fun subscribeToCustomersFeedbacks() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.customersFeedbacksState.collect {
                customersFeedbacksAdapter.submitList(it)
            }
        }
    }

}
