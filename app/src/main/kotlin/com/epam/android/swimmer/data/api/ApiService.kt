package com.epam.android.swimmer.data.api

import by.kirich1409.result.Result
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("v1/user/auth/login")
    suspend fun authorizeUser(
        @Body authObject: AuthObject,
        @Header("Origin") type: String = "https://mevis.tvoyklass.com/"
    ): Result<TokenObject>
}