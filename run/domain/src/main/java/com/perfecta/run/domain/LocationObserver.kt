package com.perfecta.run.domain

import com.perfecta.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {
    fun observeLocation(intervalMillis: Long): Flow<LocationWithAltitude>
}