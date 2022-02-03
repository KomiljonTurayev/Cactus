package com.example.cactus.domain.repository

import com.example.cactus.data.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class CactusRepository @Inject constructor(private val apiService: ApiService){

    fun getPost() = flow {
        try {
            val response = apiService.getPosts()
            emit(response)
        }catch (e:Exception){
            emit(e)
        }

    }.flowOn(Dispatchers.IO)


}