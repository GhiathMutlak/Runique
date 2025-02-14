package com.perfecta.run.location

import android.location.Location
import com.perfecta.core.domain.util.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.perfecta.core.domain.util.location.Location(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}