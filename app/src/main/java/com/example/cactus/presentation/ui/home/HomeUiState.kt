package com.example.cactus.presentation.ui.home

import com.example.cactus.domain.model.Cactus

data class HomeUiState(
    val isLoading: Boolean = false,
    val cactusList: List<Cactus> = emptyList(),
    val error: String = ""
)
