package com.geektech.beauty.presentation.ui.fragments.undefined.sideSelection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.data.local.preferences.AuthenticationPreferencesManager
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.CLIENT_ROLE_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.SALON_OWNER_ROLE_KEY
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.databinding.FragmentChooseClientOrSalonSideBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChooseClientOrSalonSideFragment :
    Fragment(R.layout.fragment_choose_client_or_salon_side) {
    @Inject
    lateinit var authenticationPreferencesManager: AuthenticationPreferencesManager

    private val binding by viewBinding(FragmentChooseClientOrSalonSideBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        performListeners()
    }

    private fun performListeners() {
        navigateToClientSideOnboard()
        navigateToBusinessSideOnboard()
    }


    private fun navigateToClientSideOnboard() {
        binding.btnChooseBeAppClient.setOnClickListener {
            authenticationPreferencesManager.userRole = CLIENT_ROLE_KEY
            findNavController().navigateSafely(R.id.action_global_to_clientAuthenticationFlowFragment)
        }
    }

    private fun navigateToBusinessSideOnboard() {
        binding.btnChooseBeAppBusiness.setOnClickListener {
            authenticationPreferencesManager.userRole = SALON_OWNER_ROLE_KEY
            findNavController().navigateSafely(R.id.action_global_to_businessAuthenticationFlowFragment)
        }
    }
}