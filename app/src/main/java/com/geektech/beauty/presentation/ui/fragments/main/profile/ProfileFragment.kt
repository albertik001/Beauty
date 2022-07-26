package com.geektech.beauty.presentation.ui.fragments.main.profile

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.getBinding
import com.geektech.beauty.core.extensions.showCustomDialog
import com.geektech.beauty.databinding.ExitDialogLayoutBinding
import com.geektech.beauty.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {

    override val binding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel by viewModels<ProfileViewModel>()

    override fun initialize() {
        super.initialize()
        btnClicks()
    }

    private fun btnClicks() {
        binding.menuSettings.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }
        binding.tvExit.setOnClickListener {
            dialogLogic()
        }
    }

    private fun dialogLogic() {
        val binding = getBinding(R.layout.exit_dialog_layout, ExitDialogLayoutBinding::bind)
        val dialog = requireContext().showCustomDialog(binding)
        binding.btnExit.setOnClickListener {
            dialog.dismiss()
        }
        binding.btnStay.setOnClickListener {
            dialog.dismiss()
        }
    }
}