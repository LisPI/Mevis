package com.epam.android.swimmer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import com.epam.android.swimmer.R
import com.epam.android.swimmer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val hostFragment: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.navHostFragment) as NavHostFragment? ?: return
        val navController = hostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}