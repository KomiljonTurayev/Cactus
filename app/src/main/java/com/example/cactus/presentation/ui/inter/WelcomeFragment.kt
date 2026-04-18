package com.example.cactus.presentation.ui.inter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cactus.R
import com.example.cactus.databinding.WelcomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.welcome_fragment) {

    private val viewModel: WelcomeViewModel by viewModels()
    private val binding by viewBinding(WelcomeFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.btnStarted.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_navigation_home)
        }
    }
}
