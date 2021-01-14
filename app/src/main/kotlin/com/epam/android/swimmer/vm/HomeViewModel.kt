package com.epam.android.swimmer.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kirich1409.result.asSuccess
import by.kirich1409.result.isSuccess
import com.epam.android.swimmer.data.api.AuthObject
import com.epam.android.swimmer.data.di.NetworkModule
import com.epam.android.swimmer.domain.GetCatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getCatUseCase: GetCatUseCase
) : ViewModel() {

    private val _loginData = MutableStateFlow<String>("")
    val loginData: StateFlow<String> = _loginData

    fun login() {
        viewModelScope.launch {
            //FIXME just for fun only!
            val retrofit = NetworkModule.provideCatsService(NetworkModule.provideRetrofit())
            val loginResult = retrofit.authorizeUser(AuthObject("paschka.lis@gmail.com", "12qwasZ"))
            if (loginResult.isSuccess()) {
                _loginData.value = loginResult.asSuccess().toString()
            }
        }
    }
}