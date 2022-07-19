package com.geektech.beauty.presentation.ui.fragments.main.home

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentHomeBinding
import com.geektech.beauty.presentation.ui.adapters.ServiceCategoryAdapter
import com.geektech.beauty.presentation.ui.adapters.ServicePopularAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val categoryAdapter = ServiceCategoryAdapter()
    private val popularAdapter = ServicePopularAdapter()

    override fun initialize() {
        binding.recyclerViewCategories.adapter = categoryAdapter
        binding.recyclerViewPopular.adapter = popularAdapter
    }

    override fun launchObservers() {
        viewModel.categoryState.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }

        viewModel.popularState.observe(viewLifecycleOwner) {
            popularAdapter.submitList(it)
        }
    }
}
