package com.example.cactus.presentation.ui.inter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
//import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cactus.R
import com.example.cactus.presentation.base.BaseFragment
import com.example.cactus.databinding.WelcomeFragmentBinding
import com.example.cactus.presentation.extensions.transparentStatusBar

class WelcomeFragment : BaseFragment(R.layout.welcome_fragment) {


    //    private  var  binding : WelcomeFragmentBinding
    private val binding by viewBinding(WelcomeFragmentBinding::bind)
    override val viewModel: WelcomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.transparentStatusBar()
        viewModel.apply {
            welcomeScreenLiveData.observe(viewLifecycleOwner, homeScreenObserver)
        }

        binding.btnNext.setOnClickListener {
//            findNavController().navigateUp()
            findNavController().navigate(R.id.navigation_home)
        }
    }

    private val homeScreenObserver = Observer<Unit> {

        //findNavController().navigate(R.id.action_splashScreen_to_homeScreen)
    }

}


