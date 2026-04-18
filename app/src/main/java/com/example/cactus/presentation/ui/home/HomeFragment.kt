package com.example.cactus.presentation.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cactus.R
import com.example.cactus.databinding.FragmentHomeBinding
import com.example.cactus.presentation.ui.home.adapters.CactusHomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var adapterCactus: CactusHomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUI()
        observeState()
    }

    private fun setUI() {
        adapterCactus = CactusHomeAdapter()
        binding.recyclerCactusHome.apply {
            adapter = adapterCactus
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
        }
        
        binding.recyclerSucculents.apply {
            adapter = adapterCactus // Reusing adapter might be okay if data is same, but usually better to have separate instances if lists differ.
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            // Handle loading
            binding.progressBar.isVisible = state.isLoading
            
            // Handle data
            if (state.cactusList.isNotEmpty()) {
                adapterCactus.setData(state.cactusList)
            }
            
            // Handle error
            if (state.error.isNotBlank()) {
                Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}