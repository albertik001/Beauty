package com.geektech.beauty.presentation.ui.fragments.main.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
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
    private val adapter = ServiceCategoryAdapter()
    private val popularAdapter = ServicePopularAdapter()

    override fun initialize() {
        binding.recyclerViewCategories.adapter = adapter
        binding.recyclerViewPopular.adapter = popularAdapter
    }

    override fun launchObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryState.observe(this@HomeFragment) {
                    adapter.submitList(it)

                }
                viewModel.popularState.observe(this@HomeFragment) {
                    popularAdapter.submitList(it)
                }
            }
        }
    }
}
