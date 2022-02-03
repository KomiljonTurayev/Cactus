package com.example.cactus.presentation.ui.inter

import androidx.lifecycle.LiveData
import com.example.cactus.presentation.base.BaseVM
import com.example.cactus.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.delay

class WelcomeViewModel : BaseVM() {

    private val _welcomeScreenLiveData = SingleLiveEvent<Unit>()
    val welcomeScreenLiveData :LiveData<Unit> = _welcomeScreenLiveData

    private val _loginSceenLiveData = SingleLiveEvent<Unit>()
    val loginScreenLiveData :LiveData<Unit> = _loginSceenLiveData

    init {
        launchVM {
            delay(3000)

        }
    }
}