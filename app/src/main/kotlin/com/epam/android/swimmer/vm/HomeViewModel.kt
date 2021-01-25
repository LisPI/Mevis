package com.epam.android.swimmer.vm

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kirich1409.result.asSuccess
import by.kirich1409.result.isSuccess
import com.epam.android.swimmer.SharedPrefSessionSource
import com.epam.android.swimmer.data.api.AuthObject
import com.epam.android.swimmer.data.db.Company
import com.epam.android.swimmer.di.NetworkModule
import com.epam.android.swimmer.domain.GetCompanyUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getCompanyUseCase: GetCompanyUseCase
) : ViewModel() {

    private val _company = MutableStateFlow<Company?>(null)
    val company: StateFlow<Company?> = _company

    fun login() {
        viewModelScope.launch {
            getCompanyUseCase.getCompany().collect { _company.value = it }
        }

        //FIXME just for fun only!
        viewModelScope.launch {

//            val retrofit = NetworkModule.provideCompanyService(NetworkModule.provideRetrofit(SharedPrefSessionSource()))
//            val loginResult = retrofit.authorizeUser(AuthObject("paschka.lis@gmail.com", "12qwasZ"))
//            if (loginResult.isSuccess()) {
//                val br = retrofit.baseInfo(authToken = loginResult.asSuccess().value.csrfToken)
//                if(br.isSuccess())
//                    Log.d("123", br.toString())
//            }
        }
    }
}