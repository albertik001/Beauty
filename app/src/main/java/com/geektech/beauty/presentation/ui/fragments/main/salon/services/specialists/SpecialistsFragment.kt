package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.databinding.FragmentSpecialistsBinding
import com.geektech.beauty.presentation.ui.adapters.home.salon.ServiceCategorySpecialistsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SpecialistsFragment :
    BaseFragment<FragmentSpecialistsBinding, SpecialistsViewModel>(R.layout.fragment_specialists) {
    override val binding by viewBinding(FragmentSpecialistsBinding::bind)
    override val viewModel by viewModels<SpecialistsViewModel>()
    private val specialistsAdapter = ServiceCategorySpecialistsAdapter(this::onItemClick)


    override fun initialize() {
        binding.rvSpecialists.adapter = specialistsAdapter
    }

    override fun performListeners() {
        navigateBack()
    }

    private fun navigateBack() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun launchObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.specialistsState.collect {
                specialistsAdapter.submitList(it)
            }
        }
    }

    private fun onItemClick(position: Int) {
        findNavController().navigateSafely(R.id.action_specialistsFragment_to_specialistProfileFragment)
    }

}