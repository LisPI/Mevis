package com.epam.android.swimmer.di

import com.epam.android.swimmer.SharedPrefSessionSource
import com.epam.android.swimmer.data.SessionSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SessionSourceModule {
    @Binds
    fun provideSource(storage: SharedPrefSessionSource): SessionSource
}