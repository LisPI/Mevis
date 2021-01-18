package com.epam.android.swimmer.di

import android.content.Context
import androidx.room.Room
import com.epam.android.swimmer.data.db.AppDatabase
import com.epam.android.swimmer.data.db.CompanyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "cache"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCatsDao(database: AppDatabase): CompanyDao {
        return database.getCompanyDao()
    }
}