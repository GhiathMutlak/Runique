package com.perfecta.auth.data

import com.perfecta.auth.domain.AuthRepository
import com.perfecta.core.data.networking.post
import com.perfecta.core.domain.util.AuthInfo
import com.perfecta.core.domain.util.DataError
import com.perfecta.core.domain.util.EmptyResult
import com.perfecta.core.domain.util.Result
import com.perfecta.core.domain.util.SessionStorage
import com.perfecta.core.domain.util.asEmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
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

    override suspend fun login(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }

        return result.asEmptyResult()
    }
}