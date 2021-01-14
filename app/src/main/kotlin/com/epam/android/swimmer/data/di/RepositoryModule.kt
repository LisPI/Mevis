package com.epam.android.swimmer.data.di

import com.epam.android.swimmer.data.repository.CatsRepository
import com.epam.android.swimmer.data.repository.CatsRepositoryImpl
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
    fun bindCatsRepository(repository: CatsRepositoryImpl): CatsRepository
}