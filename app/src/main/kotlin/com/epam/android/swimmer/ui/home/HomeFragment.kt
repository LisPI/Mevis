package com.epam.android.swimmer.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.epam.android.swimmer.R
import com.epam.android.swimmer.databinding.FragmentHomeBinding
import com.epam.android.swimmer.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private val imageAdapter = ImageAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, getItemCountInRow())
            adapter = imageAdapter
        }
        lifecycleScope.launch {
            viewModel.data.collect {
                imageAdapter.submitList(it)
            }
        }
    }

    private fun getItemCountInRow(): Int {
        val orientation = resources.configuration.orientation
        return if (orientation == Configuration.ORIENTATION_PORTRAIT)
            ITEM_IN_VERTICAL else ITEM_IN_HORIZONTAL
    }

    private companion object {
        const val ITEM_IN_VERTICAL = 2
        const val ITEM_IN_HORIZONTAL = 4
    }
}