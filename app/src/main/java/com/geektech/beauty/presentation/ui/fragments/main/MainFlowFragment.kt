package com.geektech.beauty.presentation.ui.fragments.main

import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.NavigationUiSaveStateControl
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFlowFragment
import com.geektech.beauty.databinding.FragmentMainFlowBinding


class MainFlowFragment :
    BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_fragment_main_container) {
    private val binding by viewBinding(FragmentMainFlowBinding::bind)
    override fun setupNavigation(navController: NavController) {
        establishBottomNavigation(navController)

    }

    @OptIn(NavigationUiSaveStateControl::class)
    private fun establishBottomNavigation(navController: NavController) {
        setupWithNavController(binding.bottomNavigation, navController)
        binding.bottomNavigation.setOnItemReselectedListener {
            when (NavigationUI.onNavDestinationSelected(it, navController)) {
                true -> true
                else -> when (it.itemId) {
                    R.id.homeFragment -> {
                        NavigationUI.onNavDestinationSelected(it, navController, false)
                    }
                }
            }

        }

    }

    private fun setTransparentStatusBarDependingOnTheDestination(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->


        }
    }


    private fun setTransparentStatusBarColor() {
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

    }


}