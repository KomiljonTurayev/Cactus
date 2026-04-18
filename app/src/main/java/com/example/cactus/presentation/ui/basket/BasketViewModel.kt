package com.example.cactus.presentation.ui.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cactus.domain.model.Cactus
import com.example.cactus.domain.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val basketRepository: BasketRepository
) : ViewModel() {

    private val _state = MutableLiveData<BasketUiState>()
    val state: LiveData<BasketUiState> = _state

    init {
        observeBasket()
    }

    private fun observeBasket() {
        basketRepository.getBasketItems().onEach { items ->
            // Assume price is hardcoded for now or part of model (currently not in Cactus model)
            // Let's add a fake price calculation
            val total = items.sumOf { it.quantity * 25.0 } // Fixed price for now
            _state.value = BasketUiState(items = items, totalPrice = total)
        }.launchIn(viewModelScope)
    }

    fun removeFromBasket(cactus: Cactus) {
        basketRepository.removeFromBasket(cactus)
    }

    fun addToBasket(cactus: Cactus) {
        basketRepository.addToBasket(cactus)
    }

    fun clearBasket() {
        basketRepository.clearBasket()
    }
}