package com.epam.android.swimmer.data.repository

import com.epam.android.swimmer.data.db.Company
import kotlinx.coroutines.flow.Flow

interface CompanyRepository {
    fun getCompany(): Flow<Company>
}