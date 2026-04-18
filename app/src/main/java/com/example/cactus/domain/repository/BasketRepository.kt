package com.example.cactus.domain.repository

import com.example.cactus.domain.model.BasketItem
import com.example.cactus.domain.model.Cactus
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    fun getBasketItems(): Flow<List<BasketItem>>
    fun addToBasket(cactus: Cactus)
    fun removeFromBasket(cactus: Cactus)
    fun clearBasket()
}
