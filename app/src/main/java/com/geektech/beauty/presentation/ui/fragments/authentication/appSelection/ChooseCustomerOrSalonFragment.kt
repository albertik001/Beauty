package com.geektech.beauty.presentation.ui.fragments.authentication.appSelection

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentChooseCustomerOrSalonBinding


class ChooseCustomerOrSalonFragment :
    BaseFragment<FragmentChooseCustomerOrSalonBinding, ChooseCustomerOrSalonViewModel>(R.layout.fragment_choose_customer_or_salon) {
    override val binding by viewBinding(FragmentChooseCustomerOrSalonBinding::bind)
    override val viewModel by viewModels<ChooseCustomerOrSalonViewModel>()

}