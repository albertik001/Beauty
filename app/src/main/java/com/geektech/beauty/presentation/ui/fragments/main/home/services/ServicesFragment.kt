package com.geektech.beauty.presentation.ui.fragments.main.home.services

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentServicesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ServicesFragment :
    BaseFragment<FragmentServicesBinding, ServicesViewModel>(R.layout.fragment_services) {
    override val binding by viewBinding(FragmentServicesBinding::bind)
    override val viewModel by viewModels<ServicesViewModel>()
    override fun initialize() {
    }


}