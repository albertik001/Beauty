package com.geektech.beauty.presentation.ui.fragments.authentication.signUp

import android.util.Patterns
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFragment
import com.geektech.beauty.core.extensions.mainNavController
import com.geektech.beauty.core.extensions.navigateSafely
import com.geektech.beauty.data.local.preferences.AuthenticationPreferencesManager
import com.geektech.beauty.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(R.layout.fragment_sign_up) {
    @Inject
    lateinit var authenticationPreferencesManager: AuthenticationPreferencesManager
    override val binding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel by viewModels<SignUpViewModel>()
    override fun performListeners() {
        signInIntoAccount()
    }

    private fun signInIntoAccount() {
        binding.btnSignIn.setOnClickListener {
            binding.apply {
                when {
                    etNameAndLastName.text.isNullOrBlank() && etEmail.text.isNullOrBlank() -> {
                        etNameAndLastName.error = getString(R.string.this_field_mustnt_be_empty)
                        etEmail.error = getString(R.string.this_field_mustnt_be_empty)

                    }

                    etNameAndLastName.text.toString().trim().length < 6 ->
                        etNameAndLastName.error =
                            getString(R.string.first_name_and_last_name_must_contain_at_least_6_characters)
                    etEmail.text.toString().trim().length < 6 ->
                        etEmail.error =
                            getString(R.string.email_must_contain_at_least_8_characters)

                    !Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString())
                        .matches() ->
                        etEmail.error =
                            getString(R.string.this_doesnt_look_like_email)
                    else -> {
                        authenticationPreferencesManager.isAuthenticated = true
                        mainNavController().navigateSafely(R.id.action_global_to_mainFlowFragment)
                    }
                }

            }
        }
    }


}