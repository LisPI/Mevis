package com.epam.android.swimmer.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.epam.android.swimmer.R
import com.epam.android.swimmer.databinding.FragmentExampleBinding

class ExampleFragment : Fragment(R.layout.fragment_example) {

    private val binding: FragmentExampleBinding by viewBinding(FragmentExampleBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}