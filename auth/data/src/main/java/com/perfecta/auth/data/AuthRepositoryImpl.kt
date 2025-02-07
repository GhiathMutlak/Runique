package com.perfecta.auth.data

import com.perfecta.auth.domain.AuthRepository
import com.perfecta.core.data.networking.post
import com.perfecta.core.domain.util.DataError
import com.perfecta.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
) : AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}