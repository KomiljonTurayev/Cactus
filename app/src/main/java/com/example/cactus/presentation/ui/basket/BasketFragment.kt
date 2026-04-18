package com.example.cactus.presentation.ui.basket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cactus.R
import com.example.cactus.databinding.BasketFragmentBinding
import com.example.cactus.presentation.ui.basket.adapters.BasketAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment : Fragment(R.layout.basket_fragment) {

    private val viewModel: BasketViewModel by viewModels()
    private val binding by viewBinding(BasketFragmentBinding::bind)
    private lateinit var basketAdapter: BasketAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        observeState()
    }

    private fun setupRecyclerView() {
        basketAdapter = BasketAdapter(onRemoveClick = { item ->
            viewModel.removeFromBasket(item.cactus)
        })
        binding.recyclerViewBasket.apply {
            adapter = basketAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            basketAdapter.setData(state.items)
            binding.textTotalPrice.text = "$${state.totalPrice}0"
        }
    }
}