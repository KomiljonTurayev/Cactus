package com.example.cactus.presentation.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cactus.data.remote.dto.CactusDto
import com.example.cactus.domain.repository.CactusRepository
import com.example.cactus.presentation.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val cactusRepository: CactusRepository) : ViewModel() {

    val cactusLiveData: MutableLiveData<List<CactusDto>> = MutableLiveData()

    fun getCactus() {
        viewModelScope.launch {
            cactusRepository.getPost()
                .catch { e ->
                    Log.d("ninni", "getCactus: ${e.message}")
                }.collect { response ->
                    cactusLiveData.value = response
                }
        }
    }
}
