package com.epam.android.swimmer.data.repository

import android.content.Context
import android.widget.Toast
import by.kirich1409.result.asFailure
import by.kirich1409.result.asSuccess
import by.kirich1409.result.isSuccess
import com.epam.android.swimmer.data.api.ApiService
import com.epam.android.swimmer.data.db.Company
import com.epam.android.swimmer.data.db.CompanyDao
import com.epam.android.swimmer.data.utli.mapper.CompanyMapper
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

    override fun getCompany(): Flow<Company> {
        return dao.getCompany()
    }
}