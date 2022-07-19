package com.geektech.beauty.presentation.ui.fragments.main.home.salon

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentSalonBinding
import com.geektech.beauty.presentation.models.PromotionsUI
import com.geektech.beauty.presentation.ui.adapters.PromotionsPagerAdapter

class SalonFragment : BaseFragment<FragmentSalonBinding, SalonViewModel>(R.layout.fragment_salon) {
    override val binding by viewBinding(FragmentSalonBinding::bind)
    override val viewModel by viewModels<SalonViewModel>()

    override fun initialize() {
        setPromotionsPager(viewModel.setLocalData())
    }

    private fun setPromotionsPager(data: ArrayList<PromotionsUI>) = with(
        binding.viewpagerHomePromotions
    ) {
        adapter = PromotionsPagerAdapter(data)
        binding.wormDotsIndicator.attachTo(this)
    }




}