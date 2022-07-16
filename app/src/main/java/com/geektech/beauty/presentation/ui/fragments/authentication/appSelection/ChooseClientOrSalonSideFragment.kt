package com.geektech.beauty.presentation.ui.fragments.authentication.appSelection

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.databinding.FragmentChooseClientOrSalonSideBinding


class ChooseClientOrSalonSideFragment :
    BaseFragment<FragmentChooseClientOrSalonSideBinding, ChooseClientOrSalonSideViewModel>(R.layout.fragment_choose_client_or_salon_side) {
    override val binding by viewBinding(FragmentChooseClientOrSalonSideBinding::bind)
    override val viewModel by viewModels<ChooseClientOrSalonSideViewModel>()

    override fun performListeners() {
        binding.btnChooseBeAppClient.setOnClickListener {
            findNavController().navigateSafely(R.id.action_chooseClientOrSalonSideFragment_to_onboardFragment)
        }
    }
}