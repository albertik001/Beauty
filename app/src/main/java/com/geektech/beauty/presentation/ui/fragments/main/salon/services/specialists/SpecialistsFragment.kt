package com.geektech.beauty.presentation.ui.fragments.main.salon.services.specialists

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentSpecialistsBinding
import com.geektech.beauty.presentation.ui.adapters.home.salon.ServiceCategorySpecialistsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SpecialistsFragment :
    BaseFragment<FragmentSpecialistsBinding, SpecialistsViewModel>(R.layout.fragment_specialists) {
    override val binding by viewBinding(FragmentSpecialistsBinding::bind)
    override val viewModel by viewModels<SpecialistsViewModel>()
    private val specialistsAdapter = ServiceCategorySpecialistsAdapter()
    override fun initialize() {
    }

    override fun launchObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.specialistsState.collect {
                specialistsAdapter.submitList(it)
            }
        }
    }

}