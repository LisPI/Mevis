package com.epam.android.swimmer.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.epam.android.swimmer.R
import com.epam.android.swimmer.databinding.FragmentHomeBinding
import com.epam.android.swimmer.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation(){
            val hostFragment: NavHostFragment = childFragmentManager
                .findFragmentById(R.id.homeNavHostFragment) as NavHostFragment
            val navController = hostFragment.navController
            binding.bottomNavigationView.setupWithNavController(navController)
            val appBarConfiguration = AppBarConfiguration(
                topLevelDestinationIds = setOf (
                    R.id.profileFragment,
                    R.id.scheduleFragment,
                    R.id.poolsFragment,
                    R.id.clubFragment
                )
            )
            NavigationUI.setupActionBarWithNavController(activity as MainActivity, navController, appBarConfiguration)
    }
}