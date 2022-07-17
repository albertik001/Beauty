package com.geektech.beauty.presentation.ui.fragments.authentication.onboard

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.data.local.preferences.AuthenticationPreferencesManager
import com.geektech.beauty.databinding.FragmentOnboardBinding
import com.geektech.beauty.presentation.ui.adapters.OnboardViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnboardFragment :
    BaseFragment<FragmentOnboardBinding, OnboardViewModel>(R.layout.fragment_onboard) {
    @Inject
    lateinit var authenticationPreferencesManager: AuthenticationPreferencesManager

    override val binding by viewBinding(FragmentOnboardBinding::bind)
    override val viewModel by viewModels<OnboardViewModel>()
    override fun initialize() {
        instantiateViewPager()

        navigateToSignUpIfOnboardHasBeenSeen()
    }


    private fun instantiateViewPager() {
        binding.viewPagerOnboard.adapter = OnboardViewPagerAdapter(requireActivity())
    }

    private fun navigateToSignUpIfOnboardHasBeenSeen() {
        if (authenticationPreferencesManager.hasOnboardBeenSeen)
            findNavController().navigateSafely(R.id.action_onboardFragment_to_signUpFragment)
    }


    override fun performListeners() {
        proceedToTheNextStep()
        skipOnboard()

    }

    private fun skipOnboard() {
        binding.tvSkipOnboard.setOnClickListener {
            authenticationPreferencesManager.hasOnboardBeenSeen = true
            findNavController().navigateSafely(R.id.action_onboardFragment_to_signUpFragment)
        }
    }

    private fun proceedToTheNextStep() {
        binding.btnProceedToTheNextStep.setOnClickListener {
            binding.viewPagerOnboard.apply {
                when (currentItem < 2) {
                    true -> setCurrentItem(
                        currentItem + 1,
                        true
                    )
                    else -> {
                        authenticationPreferencesManager.hasOnboardBeenSeen = true
                        findNavController().navigateSafely(R.id.action_onboardFragment_to_signUpFragment)
                    }

                }
            }

        }
    }

}