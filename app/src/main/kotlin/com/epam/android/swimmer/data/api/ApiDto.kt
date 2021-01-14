package com.epam.android.swimmer.data.api

import kotlinx.serialization.Serializable

@Serializable
data class AuthObject(
    val login: String,
    val password: String
)

@Serializable
data class TokenObject(
    var csrfToken: String,
    var expiresAt: String,
    var level: String,
)