package com.example.cactus.domain.repository

import com.example.cactus.common.Resource
import com.example.cactus.domain.model.Cactus
import kotlinx.coroutines.flow.Flow

interface CactusRepository {
    fun getPosts(): Flow<Resource<List<Cactus>>>
}