package com.example.cactus.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
    return withContext(Dispatchers.IO) {
        try {
            Resource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Resource.Error("Network Error: Please check your internet connection")
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = throwable.response()?.errorBody()?.string()
                    Resource.Error("HTTP Error $code: $errorResponse")
                }
                else -> {
                    Resource.Error("Unknown Error: ${throwable.localizedMessage}")
                }
            }
        }
    }
}
