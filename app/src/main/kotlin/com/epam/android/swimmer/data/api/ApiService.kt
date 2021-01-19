package com.epam.android.swimmer.data.api

import by.kirich1409.result.Result
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

private const val ORIGIN = "https://mevis.tvoyklass.com/"

interface ApiService {
    @POST("v1/user/auth/login")
    suspend fun authorizeUser(
        @Body authObject: AuthObject,
        @Header("Origin") type: String = ORIGIN
    ): Result<TokenObject>

    @GET("v1/user/lkSettings")
    suspend fun lkSettings(
        @Header("Referer") type: String = ORIGIN
    ): Result<LkSettings>

    @GET("v1/user/baseInfo")
    suspend fun baseInfo(
        @Header("Referer") type: String = ORIGIN,
        @Header("x-csrf-token") authToken: String
    ): Result<BaseInfo>
}