package com.perfecta.core.domain.run

import com.perfecta.core.domain.util.DataError
import com.perfecta.core.domain.util.EmptyResult
import com.perfecta.core.domain.util.Result

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}