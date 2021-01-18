package com.epam.android.swimmer.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCompany(company: Company)

    @Query("SELECT * FROM company")
    fun getCompany(): Flow<Company>
}