package com.epam.android.swimmer.data.di

import by.kirich1409.result.retrofit.ResultAdapterFactory
import com.epam.android.swimmer.data.api.CatsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    @ExperimentalSerializationApi
    fun provideRetrofit(): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val converterFactory =
            json.asConverterFactory("application/json".toMediaType())
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com")
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(ResultAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideCatsService(retrofit: Retrofit): CatsService {
        return retrofit.create(CatsService::class.java)
    }
}