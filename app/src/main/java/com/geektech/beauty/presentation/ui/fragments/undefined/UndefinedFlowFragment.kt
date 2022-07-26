package com.geektech.beauty.presentation.ui.fragments.undefined

import androidx.navigation.NavController
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFlowFragment
import com.geektech.beauty.core.data.local.preferences.AuthenticationPreferencesManager
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.CLIENT_ROLE_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.SALON_OWNER_ROLE_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.UNDEFINED_KEY
import com.geektech.beauty.core.extensions.setStatusBarColor
import com.geektech.beauty.core.extensions.setStatusBarLightAppearance
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UndefinedFlowFragment :
    BaseFlowFragment(R.layout.fragment_undefined_flow, R.id.nav_host_fragment_undefined_container) {

    @Inject
    lateinit var authenticationPreferencesManager: AuthenticationPreferencesManager

    override fun setupNavigation(navController: NavController) {
        defineStartDestination(navController)
    }

    private fun defineStartDestination(navController: NavController) {
        val navGraph = navController.navInflater.inflate(R.navigation.undefined_graph)
        when (authenticationPreferencesManager.userRole) {
            UNDEFINED_KEY -> {
                navGraph.setStartDestination(R.id.chooseClientOrSalonSideFragment)
                setStatusBarLightAppearance(false)
                setStatusBarColor(R.color.cendreBlue)
            }
            CLIENT_ROLE_KEY -> navGraph.setStartDestination(R.id.clientAuthenticationFlowFragment)
            SALON_OWNER_ROLE_KEY -> navGraph.setStartDestination(R.id.businessAuthenticationFlowFragment)
        }
        navController.graph = navGraph
    }


}