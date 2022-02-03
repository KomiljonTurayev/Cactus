package com.example.cactus.data

import com.example.cactus.data.remote.dto.CactusDto
import retrofit2.http.GET

interface ApiService{

    @GET("posts")
    suspend fun getPosts():List<CactusDto>
}