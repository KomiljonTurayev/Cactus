package com.example.cactus.presentation.ui.basket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cactus.R
import com.example.cactus.databinding.BasketFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment : Fragment(R.layout.basket_fragment) {

    private val viewModel: BasketViewModel by viewModels()
    private val binding by viewBinding(BasketFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}