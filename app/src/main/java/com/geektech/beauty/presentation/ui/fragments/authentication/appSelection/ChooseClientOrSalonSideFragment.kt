package com.geektech.beauty.presentation.ui.fragments.authentication.appSelection

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.data.local.preferences.AuthenticationPreferencesManager
import com.geektech.beauty.databinding.FragmentChooseClientOrSalonSideBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChooseClientOrSalonSideFragment :
    BaseFragment<FragmentChooseClientOrSalonSideBinding, ChooseClientOrSalonSideViewModel>(R.layout.fragment_choose_client_or_salon_side) {
    @Inject
    lateinit var authenticationPreferencesManager: AuthenticationPreferencesManager
    override val binding by viewBinding(FragmentChooseClientOrSalonSideBinding::bind)
    override val viewModel by viewModels<ChooseClientOrSalonSideViewModel>()
    override fun initialize() {
        navigateToClientOnboardIfUserIsAClient()
    }

    private fun navigateToClientOnboardIfUserIsAClient() {

        if (authenticationPreferencesManager.isUserAClient)
            findNavController().navigateSafely(R.id.action_chooseClientOrSalonSideFragment_to_onboardFragment)

    }


    override fun performListeners() {
        navigateToClientSideOnboard()
    }

    private fun navigateToClientSideOnboard() {
        binding.btnChooseBeAppClient.setOnClickListener {
            authenticationPreferencesManager.isUserAClient = true
            findNavController().navigateSafely(R.id.action_chooseClientOrSalonSideFragment_to_onboardFragment)
        }
    }
}