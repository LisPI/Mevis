package com.epam.android.swimmer.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kirich1409.result.asSuccess
import by.kirich1409.result.isSuccess
import com.epam.android.swimmer.data.SessionSource
import com.epam.android.swimmer.data.api.ApiService
import com.epam.android.swimmer.data.api.AuthObject
import com.epam.android.swimmer.data.api.UsersItem
import com.epam.android.swimmer.data.db.Company
import com.epam.android.swimmer.domain.GetCompanyUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getCompanyUseCase: GetCompanyUseCase,
    private val api: ApiService, //FIXME delete after testing
    private val session: SessionSource
) : ViewModel() {

    private val _company = Channel<Company>()
    val company = _company.receiveAsFlow()

    private val _user = Channel<UsersItem>()
    val user = _user.receiveAsFlow()

    private val _login = MutableStateFlow("")
    val login: StateFlow<String> = _login

    fun login() {
//        viewModelScope.launch {
//            getCompanyUseCase.getCompany().collect { _company.value = it }
//        }

        //FIXME just for fun only!
        viewModelScope.launch {

            val loginResult = api.authorizeUser(AuthObject("paschka.lis@gmail.com", "12qwasZ"))
            if (loginResult.isSuccess()) {
                session.saveSession(loginResult.asSuccess().value.csrfToken)
                _login.value = loginResult.asSuccess().value.csrfToken
            }
        }
    }

    fun getCompany() {
        viewModelScope.launch {
            val lkSettings = api.lkSettings()
            if (lkSettings.isSuccess()) {
                val company = lkSettings.asSuccess().value.contacts
                _company.send(Company(company.name
                    ?: "", company.phone, company.email, company.full))
                _login.value = "no token needed"

            }
        }
    }

    fun getUser() {
        viewModelScope.launch {
            val baseInfo = api.baseInfo(authToken = _login.value)
            if (baseInfo.isSuccess()) {
                _user.send(baseInfo.asSuccess().value.users?.first()!!)
            } else
                _login.value = "bad token"
        }
    }

    fun logout() {
        session.deleteSession()
        session.deleteCookie()
        _login.value = session.getSavedSession()
    }
}