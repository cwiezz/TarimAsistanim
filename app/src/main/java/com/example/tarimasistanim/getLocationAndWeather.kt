package com.example.tarimasistanim

import android.Manifest
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult


@RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
fun getLocationAndWeather(
    fusedLocationClient: FusedLocationProviderClient,
    weatherApi: WeatherApi,
    scope: CoroutineScope,
    onResult: (String) -> Unit
) {
    val locationRequest = LocationRequest.create().apply {
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        interval = 0
        numUpdates = 1
    }

    val locationCallback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            val location = result.lastLocation
            if (location != null) {
                scope.launch {
                    try {
                        val response = weatherApi.getWeatherByCoords(
                            lat = location.latitude,
                            lon = location.longitude,
                            apiKey = "3584e980ff83e92100820714fa8a1264"
                        )
                        val result = "${response.name} - ${response.main.temp}°C, ${response.weather.firstOrNull()?.description ?: "N/A"}"
                        onResult(result)
                    } catch (e: Exception) {
                        onResult("Hava durumu alınamadı: ${e.localizedMessage}")
                    }
                }
            } else {
                onResult("Güncel konum alınamadı.")
            }
        }
    }

    fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
}
