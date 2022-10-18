package com.geektech.beauty.presentation.ui.fragments.main.salons

import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentSalonsBinding
import com.geektech.beauty.presentation.ui.adapters.SalonsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SalonsFragment :
    BaseFragment<FragmentSalonsBinding, SalonsViewModel>(R.layout.fragment_salons) {
    override val binding by viewBinding(FragmentSalonsBinding::bind)
    override val viewModel by viewModels<SalonsViewModel>()
    private val adapter = SalonsAdapter()


    override fun initialize() {
        binding.rvSalons.adapter = adapter
        adapterClick()
    }

    private fun adapterClick() {
        adapter.onClick = {
            Toast.makeText(requireContext(), "Adapter click", Toast.LENGTH_SHORT).show()
        }
    }

    override fun launchObservers() {
        viewModel.salonsState.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}