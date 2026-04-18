package com.example.cactus.data.mapper

import com.example.cactus.data.remote.dto.CactusDto
import com.example.cactus.domain.model.Cactus

fun CactusDto.toDomain(): Cactus {
    return Cactus(
        id = id ?: 0,
        title = title ?: "",
        url = url ?: "",
        thumbnailUrl = thumbnailUrl ?: ""
    )
}
