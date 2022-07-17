package com.geektech.beauty.presentation.ui.fragments.authentication.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.databinding.FragmentOnboardStepBinding


class OnboardStepFragment : Fragment(R.layout.fragment_onboard_step) {
    private val binding by viewBinding(FragmentOnboardStepBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constructViews()
    }

    private fun constructViews() {
        replaceViewsDependingOnThePosition()
    }

    private fun replaceViewsDependingOnThePosition() = with(binding) {
        when (requireArguments().getInt(ONBOARD_STEP_NUMBER)) {

            0 -> {
                imOnboard.setImageResource(R.drawable.ic_onboard_first_step)
                tvOnboardTitle.text = getString(R.string.distance_in_few_taps_from_next_appointment)
                tvOnboardDescription.text =
                    getString(R.string.the_application_to_salon_appointment_your_appointment_is_effortless_and_reliable)
            }
            1 -> {
                imOnboard.setImageResource(R.drawable.ic_onboard_first_step)
                tvOnboardTitle.text = getString(R.string.find_your_best_salon)
                tvOnboardDescription.text =
                    getString(R.string.you_can_find_salon_that_you_are_good_with)

            }
            2 -> {
                imOnboard.setImageResource(R.drawable.ic_onboard_first_step)
                tvOnboardTitle.text = getString(R.string.make_your_appointment_effortless)
                tvOnboardDescription.text =
                    getString(R.string.online_appointment_choose_your_time_salon_and_procedure)

            }
        }
    }

    companion object {
        const val ONBOARD_STEP_NUMBER = "stepNumber"
    }
}