package com.geektech.beauty.presentation.ui.fragments.main.profile.settings

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment :
    BaseFragment<FragmentSettingsBinding, SettingsViewModel>(R.layout.fragment_settings) {

    override val binding by viewBinding(FragmentSettingsBinding::bind)
    override val viewModel by viewModels<SettingsViewModel>()

    override fun initialize() {
        super.initialize()
        btnClicks()
    }

    private fun btnClicks() {
        binding.tvImageEdit.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_editProfileFragment)
        }
        binding.menuBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}