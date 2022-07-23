package com.geektech.beauty.presentation.ui.fragments.main.profile.settings.edit

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.databinding.FragmentEditProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileFragment :
    BaseFragment<FragmentEditProfileBinding, EditProfileViewModel>(R.layout.fragment_edit_profile) {

    override val binding by viewBinding(FragmentEditProfileBinding::bind)
    override val viewModel by viewModels<EditProfileViewModel>()

    override fun initialize() {
        super.initialize()
        btnClicks()
    }

    private fun btnClicks() {
        binding.menuBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnSaveChanges.setOnClickListener {
            if (binding.etData.text.isNotEmpty() &&
                binding.etNameSurname.text.isNotEmpty() &&
                binding.etPhoneNumber.text.isNotEmpty()
            ) {
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Field's can't be blank", Toast.LENGTH_SHORT).show()
            }
        }
    }
}