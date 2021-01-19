package com.epam.android.swimmer.data.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import by.kirich1409.result.asFailure
import by.kirich1409.result.asSuccess
import by.kirich1409.result.isSuccess
import com.epam.android.swimmer.data.api.ApiService
import com.epam.android.swimmer.data.api.AuthObject
import com.epam.android.swimmer.data.db.Company
import com.epam.android.swimmer.data.db.CompanyDao
import com.epam.android.swimmer.data.utli.mapper.CompanyMapper
import com.epam.android.swimmer.di.NetworkModule
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: CompanyDao,
    private val companyMapper: CompanyMapper,
    @ApplicationContext private val appContext: Context
) : CompanyRepository {

    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        scope.launch {
            loadCompany()
        }
    }

    private suspend fun loadCompany() {
        withContext(Dispatchers.IO) {
            val result = api.lkSettings()
            if (result.isSuccess()) {
                val company = companyMapper.map(result.asSuccess().value.contacts)
                dao.saveCompany(company)
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        appContext,
                        result.asFailure().error.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    suspend fun testCookie() {
        withContext(Dispatchers.IO) {
            val retrofit = NetworkModule.provideCatsService(NetworkModule.provideRetrofit(appContext))
            val loginResult = retrofit.authorizeUser(AuthObject("paschka.lis@gmail.com", "12qwasZ"))
            if (loginResult.isSuccess()) {
                val br = retrofit.baseInfo(authToken = loginResult.asSuccess().value.csrfToken)
                if (br.isSuccess())
                    Log.d("123", br.toString())
            }
        }
    }

    override fun getCompany(): Flow<Company> {
        scope.launch { testCookie()}
        return dao.getCompany()
    }
}