package com.geektech.beauty.presentation.ui.adapters

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geektech.beauty.presentation.ui.fragments.authentication.onboard.OnboardStepFragment
import com.geektech.beauty.presentation.ui.fragments.authentication.onboard.OnboardStepFragment.Companion.ONBOARD_STEP_NUMBER

class OnboardViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int) = OnboardStepFragment().apply {
        arguments = Bundle().apply {

            putInt(ONBOARD_STEP_NUMBER, position)
        }

    }


    override fun getItemCount() = STEP_COUNT


    companion object {
        private const val STEP_COUNT = 3
    }
}