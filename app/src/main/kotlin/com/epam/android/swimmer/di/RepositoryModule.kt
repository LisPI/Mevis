package com.epam.android.swimmer.di

import com.epam.android.swimmer.data.repository.CompanyRepository
import com.epam.android.swimmer.data.repository.CompanyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindCatsRepository(repository: CompanyRepositoryImpl): CompanyRepository
}