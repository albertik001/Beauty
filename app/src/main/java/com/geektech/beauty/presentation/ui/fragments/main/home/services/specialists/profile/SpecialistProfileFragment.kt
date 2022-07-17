package com.geektech.beauty.presentation.ui.fragments.main.home.services.specialists.profile

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentSpecialistProfileBinding


class SpecialistProfileFragment :
    BaseFragment<FragmentSpecialistProfileBinding, SpecialistProfileViewModel>(R.layout.fragment_specialist_profile) {
    override val binding by viewBinding(FragmentSpecialistProfileBinding::bind)
    override val viewModel by viewModels<SpecialistProfileViewModel>()

}
