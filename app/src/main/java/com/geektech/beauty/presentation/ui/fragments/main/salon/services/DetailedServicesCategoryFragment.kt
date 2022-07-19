package com.geektech.beauty.presentation.ui.fragments.main.salon.services

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.databinding.FragmentDetailedServicesCategoryBinding
import com.geektech.beauty.presentation.ui.adapters.home.salon.DetailedServiceCategoryAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailedServicesCategoryFragment :
    BaseFragment<FragmentDetailedServicesCategoryBinding, DetailedServicesCategoryViewModel>(R.layout.fragment_detailed_services_category) {
    override val binding by viewBinding(FragmentDetailedServicesCategoryBinding::bind)
    override val viewModel by viewModels<DetailedServicesCategoryViewModel>()
    private val detailedServiceCategoryAdapter = DetailedServiceCategoryAdapter(this::onItemClick)


    override fun initialize() {
        instantiateRecycler()
    }

    private fun instantiateRecycler() {
        binding.rvServices.adapter = detailedServiceCategoryAdapter
    }


    override fun performListeners() {
        navigateBackToHome()
        navigateToCategorySpecialists()
    }


    private fun navigateBackToHome() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun navigateToCategorySpecialists() {
    }


    override fun launchObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.detailedServicesState.collect {
                detailedServiceCategoryAdapter.submitList(it)
            }
        }
    }

    private fun onItemClick() {
        findNavController().navigateSafely(R.id.action_detailedServicesCategoryFragment_to_specialistsFragment)
    }

}