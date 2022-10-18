package com.geektech.beauty.presentation.ui.fragments.authentication

import androidx.navigation.NavController
import com.geektech.beauty.R
import com.geektech.beauty.core.base.BaseFlowFragment
import com.geektech.beauty.core.data.local.preferences.AuthenticationPreferencesManager
import com.geektech.beauty.core.extensions.setStatusBarColor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ClientAuthenticationFlowFragment : BaseFlowFragment(
    R.layout.fragment_client_authentication_flow,
    R.id.nav_host_fragment_authentication_container
) {
    @Inject
    lateinit var authenticationPreferencesManager: AuthenticationPreferencesManager
    override fun setupNavigation(navController: NavController) {
        defineStartDestination(navController)
    }

    private fun defineStartDestination(navController: NavController) {
        val navGraph = navController.navInflater.inflate(R.navigation.client_authentication_graph)
        when (authenticationPreferencesManager.isClientAuthenticated) {
            false -> {
                navGraph.setStartDestination(R.id.onboardFragment)
                setStatusBarColor(com.geektech.beauty.core.R.color.artisticViolet)
            }
            true -> {
                navGraph.setStartDestination(R.id.clientMainFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}