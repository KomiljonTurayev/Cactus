package com.example.cactus.presentation.ui.label

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cactus.R
import com.example.cactus.databinding.LabelFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LabelFragment : Fragment(R.layout.label_fragment) {

    private val viewModel: LabelViewModel by viewModels()
    private val binding by viewBinding(LabelFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}