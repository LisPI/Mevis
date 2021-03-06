package com.epam.android.swimmer.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Company::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCompanyDao(): CompanyDao
}