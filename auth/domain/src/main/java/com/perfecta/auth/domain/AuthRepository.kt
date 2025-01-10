package com.perfecta.auth.domain

import com.perfecta.core.domain.util.DataError
import com.perfecta.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}