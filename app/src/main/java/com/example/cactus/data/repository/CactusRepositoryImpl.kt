package com.example.cactus.data.repository

import com.example.cactus.common.Resource
import com.example.cactus.common.safeApiCall
import com.example.cactus.data.ApiService
import com.example.cactus.data.mapper.toDomain
import com.example.cactus.domain.model.Cactus
import com.example.cactus.domain.repository.CactusRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CactusRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CactusRepository {

    override fun getPosts(): Flow<Resource<List<Cactus>>> = flow {
        emit(Resource.Loading())
        val result = safeApiCall { 
            apiService.getPosts().map { it.toDomain() }
        }
        emit(result)
    }
}
