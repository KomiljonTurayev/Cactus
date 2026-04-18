package com.example.cactus.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cactus.common.Resource
import com.example.cactus.domain.repository.CactusRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cactusRepository: CactusRepository,
    private val basketRepository: BasketRepository
) : ViewModel() {

    private val _state = MutableLiveData<HomeUiState>()
    val state: LiveData<HomeUiState> = _state

    init {
        getCactus()
    }

    fun addToBasket(cactus: Cactus) {
        basketRepository.addToBasket(cactus)
    }

    private fun getCactus() {
        cactusRepository.getPosts().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = HomeUiState(cactusList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = HomeUiState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = HomeUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
