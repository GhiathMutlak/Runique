package com.perfecta.core.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.System
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

object Timer {
    fun timeAndEmit(): Flow<Duration> {
        return flow {
            var lastTimeEmit = System.currentTimeMillis()

            while (true) {
                delay(200L)
                val currentTime = System.currentTimeMillis()
                val elapsedTime = currentTime - lastTimeEmit

                emit(elapsedTime.milliseconds)

                lastTimeEmit = currentTime
            }
        }
    }
}