package com.example.cactus.presentation.ui.basket

import com.example.cactus.domain.model.BasketItem

data class BasketUiState(
    val items: List<BasketItem> = emptyList(),
    val totalPrice: Double = 0.0
)
