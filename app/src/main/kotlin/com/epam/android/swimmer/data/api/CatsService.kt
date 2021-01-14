package com.epam.android.swimmer.data.api

import by.kirich1409.result.Result
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatsService {
    @GET("/v1/images/search")
    suspend fun getCats(
        @Header("x-api-key") apiKey: String = "5156228e-2221-4250-b1e1-27c7f4661762",
        @Query("limit") limit: Int = 30
    ): Result<List<ApiCat>>
}