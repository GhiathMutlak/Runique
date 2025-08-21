package com.perfecta.run.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.core.content.getSystemService
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.perfecta.core.domain.location.LocationWithAltitude
import com.perfecta.run.domain.LocationObserver
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AndroidLocationObserver(
    private val context: Context
) : LocationObserver {

    private val locationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    override fun observeLocation(intervalMillis: Long): Flow<LocationWithAltitude> {
        return callbackFlow {
            val locationManager = context.getSystemService<LocationManager>()!!

            var isGpsEnabled = false
            var isNetworkEnabled = false

            while (!isGpsEnabled && !isNetworkEnabled) {
                isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                isNetworkEnabled =
                    locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

                if (!isGpsEnabled && !isNetworkEnabled) {
                    delay(3000L)
                }
            }

            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                close()
            } else {
                try {
                    locationProviderClient.lastLocation.addOnSuccessListener {
                        try {
                            trySend(it.toLocationWithAltitude())
                        } catch (_: NullPointerException) {}
                    }
                } catch (_: NullPointerException) {}

                val request =
                    LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, intervalMillis)
                        .build()

                val locationCallback = object : LocationCallback() {
                    override fun onLocationResult(result: LocationResult) {
                        super.onLocationResult(result)
                        result.locations.lastOrNull()?.let { location ->
                            trySend(location.toLocationWithAltitude())
                        }
                    }
                }

                locationProviderClient.requestLocationUpdates(
                    request,
                    locationCallback,
                    Looper.getMainLooper()
                )

                awaitClose {
                    locationProviderClient.removeLocationUpdates(locationCallback)
                }
            }
        }
    }
}