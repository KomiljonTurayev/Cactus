package com.example.cactus.presentation.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cactus.R
import com.example.cactus.data.remote.dto.CactusDto
import com.example.cactus.databinding.FragmentHomeBinding
import com.example.cactus.presentation.ui.home.adapters.CactusHomeAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    val viewModel: HomeViewModel by viewModels()
    private val _binding by viewBinding(FragmentHomeBinding::bind)
    var recyclerView = _binding.recyclerCactusHome
    val recyclerViewSuc = _binding.recyclerSucculents
    private lateinit var adapterCactus: CactusHomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.apply {
//            homeScreenLiveData.observe(viewLifecycleOwner, homeFramgentObserver)
//        }


        setUI()
        viewModel.getCactus()
        viewModel.cactusLiveData.observe(requireActivity()) { response ->
            adapterCactus.setData(response as ArrayList<CactusDto>)
        }

    }

    private fun setUI() {
        adapterCactus = CactusHomeAdapter(requireContext(), ArrayList())
        recyclerView.adapter = adapterCactus
        recyclerViewSuc.adapter = adapterCactus
        recyclerView.apply {
            setHasFixedSize(true)
            recyclerView.layoutManager =
                GridLayoutManager(activity, 2)

            recyclerViewSuc.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        }
    }

    private val homeFramgentObserver = Observer<List<Unit>> { it ->
//        val adapterCactus = CactusHomeAdapter(it)

    }



}