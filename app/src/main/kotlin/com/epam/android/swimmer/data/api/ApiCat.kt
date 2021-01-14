package com.epam.android.swimmer.data.api

import kotlinx.serialization.Serializable

@Serializable
data class ApiCat(
    val id: String,
    val url: String
)