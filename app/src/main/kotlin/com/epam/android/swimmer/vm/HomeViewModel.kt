package com.epam.android.swimmer.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epam.android.swimmer.data.db.Company
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
    }
}