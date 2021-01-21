package com.epam.android.swimmer.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.epam.android.swimmer.R
import com.epam.android.swimmer.databinding.FragmentBlankBinding
import com.epam.android.swimmer.databinding.FragmentHomeBinding
import com.epam.android.swimmer.ui.LoginFragmentDirections

class BlankFragment : Fragment(R.layout.fragment_blank) {

    private val binding: FragmentBlankBinding by viewBinding(FragmentBlankBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonToTest.setOnClickListener {
            navigateToTest()
        }
    }

    //example of how to go from fragment of home_nav_graph to fragment of nav_graph
    private fun navigateToTest(){
            parentFragment?.parentFragment?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToExampleFragment())
    }
}