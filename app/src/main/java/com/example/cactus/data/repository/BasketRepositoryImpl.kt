package com.example.cactus.data.repository

import com.example.cactus.domain.model.BasketItem
import com.example.cactus.domain.model.Cactus
import com.example.cactus.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BasketRepositoryImpl @Inject constructor() : BasketRepository {

    private val _basketItems = MutableStateFlow<List<BasketItem>>(emptyList())
    
    override fun getBasketItems(): Flow<List<BasketItem>> = _basketItems.asStateFlow()

    override fun addToBasket(cactus: Cactus) {
        val currentItems = _basketItems.value.toMutableList()
        val existingItem = currentItems.find { it.cactus.id == cactus.id }
        
        if (existingItem != null) {
            val index = currentItems.indexOf(existingItem)
            currentItems[index] = existingItem.copy(quantity = existingItem.quantity + 1)
        } else {
            currentItems.add(BasketItem(cactus, 1))
        }
        
        _basketItems.value = currentItems
    }

    override fun removeFromBasket(cactus: Cactus) {
        val currentItems = _basketItems.value.toMutableList()
        val existingItem = currentItems.find { it.cactus.id == cactus.id }
        
        if (existingItem != null) {
            if (existingItem.quantity > 1) {
                val index = currentItems.indexOf(existingItem)
                currentItems[index] = existingItem.copy(quantity = existingItem.quantity - 1)
            } else {
                currentItems.remove(existingItem)
            }
        }
        
        _basketItems.value = currentItems
    }

    override fun clearBasket() {
        _basketItems.value = emptyList()
    }
}
