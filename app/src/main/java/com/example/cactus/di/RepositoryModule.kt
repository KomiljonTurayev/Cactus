package com.example.cactus.di

import com.example.cactus.data.repository.BasketRepositoryImpl
import com.example.cactus.data.repository.CactusRepositoryImpl
import com.example.cactus.domain.repository.BasketRepository
import com.example.cactus.domain.repository.CactusRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCactusRepository(
        cactusRepositoryImpl: CactusRepositoryImpl
    ): CactusRepository

    @Binds
    @Singleton
    abstract fun bindBasketRepository(
        basketRepositoryImpl: BasketRepositoryImpl
    ): BasketRepository
}
