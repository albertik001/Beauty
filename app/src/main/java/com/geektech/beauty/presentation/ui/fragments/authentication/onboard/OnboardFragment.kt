package com.geektech.beauty.presentation.ui.fragments.authentication.onboard

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.data.local.preferences.AuthenticationPreferencesManager
import com.geektech.beauty.databinding.FragmentOnboardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnboardFragment :
    BaseFragment<FragmentOnboardBinding, OnboardViewModel>(R.layout.fragment_onboard) {
    @Inject
    lateinit var authenticationPreferencesManager: AuthenticationPreferencesManager
    override val binding by viewBinding(FragmentOnboardBinding::bind)
    override val viewModel by viewModels<OnboardViewModel>()

}