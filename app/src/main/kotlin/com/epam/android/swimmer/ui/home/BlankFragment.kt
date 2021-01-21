package com.epam.android.swimmer.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.epam.android.swimmer.R
import com.epam.android.swimmer.databinding.FragmentBlankBinding
import com.epam.android.swimmer.databinding.FragmentHomeBinding

class BlankFragment : Fragment(R.layout.fragment_blank) {

    private val binding: FragmentBlankBinding by viewBinding(FragmentBlankBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}