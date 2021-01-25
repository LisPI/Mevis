package com.epam.android.swimmer.di

import by.kirich1409.result.retrofit.ResultAdapterFactory
import com.epam.android.swimmer.data.SessionSource
import com.epam.android.swimmer.data.api.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    @ExperimentalSerializationApi
    fun provideRetrofit(session: SessionSource): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val converterFactory =
            json.asConverterFactory("application/json".toMediaType())

        val setCookieHeader = "Set-Cookie"
        val cookieHeader = "Cookie"
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalResponse = chain.proceed(chain.request())
                if (originalResponse.headers(setCookieHeader).isNotEmpty()) {
                    session.saveCookie(originalResponse.headers(setCookieHeader).toHashSet())
                }
                originalResponse
            }
            .addInterceptor { chain ->
                val builder = chain.request().newBuilder()

                session.getSavedCookie().forEach {
                    builder.addHeader(cookieHeader, it)
                }

                chain.proceed(builder.build())
            }
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://api.moyklass.com/")
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(ResultAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideCompanyService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}