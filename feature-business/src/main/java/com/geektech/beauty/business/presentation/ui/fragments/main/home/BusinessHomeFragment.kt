package com.geektech.beauty.business.presentation.ui.fragments.main.home

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.business.R
import com.geektech.beauty.business.databinding.FragmentBusinessHomeBinding
import com.geektech.beauty.core.base.BaseFragment


class BusinessHomeFragment :
    BaseFragment<FragmentBusinessHomeBinding, BusinessHomeViewModel>(R.layout.fragment_business_home) {
    override val binding by viewBinding(FragmentBusinessHomeBinding::bind)
    override val viewModel by viewModels<BusinessHomeViewModel>()

    override fun initialize() {
    }

    override fun performListeners() {

    }
}