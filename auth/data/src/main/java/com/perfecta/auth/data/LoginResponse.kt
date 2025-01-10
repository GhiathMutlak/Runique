package com.perfecta.auth.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val userId: String,
    val accessTokenExpirationTimestamp: Long
)
