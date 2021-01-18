package com.epam.android.swimmer.domain

import com.epam.android.swimmer.data.db.Company
import com.epam.android.swimmer.data.repository.CompanyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCompanyUseCase @Inject constructor(
    private val repository: CompanyRepository
) {
    fun getCompany(): Flow<Company> {
        return repository.getCompany()
    }
}