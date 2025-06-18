//package com.example.tarimasistanim
//
//import android.Manifest
//import android.annotation.SuppressLint
//import android.content.Context
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.google.accompanist.permissions.ExperimentalPermissionsApi
//import com.google.accompanist.permissions.isGranted
//import com.google.accompanist.permissions.rememberPermissionState
//import com.google.android.gms.location.LocationServices
//import kotlinx.coroutines.tasks.await
//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun WeatherCard() {
//    val context = LocalContext.current
//    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
//    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }
//
//    LaunchedEffect(Unit) {
//        // Uygulama ilk açıldığında çalışır
//        if (!permissionState.status.isGranted) {
//            permissionState.launchPermissionRequest()
//        } else {
//            weatherData = getWeather(context)
//        }
//    }
//
//    // Eğer kullanıcı izni daha sonradan verdiyse yeniden dene
//    LaunchedEffect(permissionState.status.isGranted) {
//        if (permissionState.status.isGranted && weatherData == null) {
//            weatherData = getWeather(context)
//        }
//    }
//
//    // Görsel olarak kart (yeşil alan içindeki)
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        shape = RoundedCornerShape(24.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFF1EB4D4)) // Mavi arkaplan
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(24.dp),
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = "Hava Durumu",
//                fontSize = 20.sp,
//                color = Color.White
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            if (weatherData != null) {
//                Text(
//                    text = "${weatherData!!.main.temp}° - ${weatherData!!.weather.firstOrNull()?.description}",
//                    fontSize = 16.sp,
//                    color = Color.White
//                )
//            } else {
//                Text("Yükleniyor...", fontSize = 14.sp, color = Color.White)
//            }
//        }
//    }
//}
//
//@SuppressLint("MissingPermission")
//suspend fun getWeather(context: Context): WeatherResponse? {
//    val fusedLocationProvider = LocationServices.getFusedLocationProviderClient(context)
//    val location = fusedLocationProvider.lastLocation.await()
//    val lat = location.latitude
//    val lon = location.longitude
//    val apiKey = "1a976f9311e0706dd23ef5e33ad6e0f7" // API anahtarın
//
//    return RetrofitInstance.api.getWeatherByCoords(lat, lon, apiKey)
//}


//package com.example.tarimasistanim
//
//import android.Manifest
//import android.annotation.SuppressLint
//import android.content.Context
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.google.accompanist.permissions.ExperimentalPermissionsApi
//import com.google.accompanist.permissions.isGranted
//import com.google.accompanist.permissions.rememberPermissionState
//import com.google.android.gms.location.LocationServices
//import kotlinx.coroutines.tasks.await
//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun WeatherCard() {
//    val context = LocalContext.current
//    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
//    var weatherData by remember { mutableStateOf<WeatherResponse?>(null) }
//
//    LaunchedEffect(Unit) {
//        // Uygulama ilk açıldığında çalışır
//        if (!permissionState.status.isGranted) {
//            permissionState.launchPermissionRequest()
//        } else {
//            weatherData = getWeather(context)
//        }
//    }
//
//    // Eğer kullanıcı izni daha sonradan verdiyse yeniden dene
//    LaunchedEffect(permissionState.status.isGranted) {
//        if (permissionState.status.isGranted && weatherData == null) {
//            weatherData = getWeather(context)
//        }
//    }
//
//    // Görsel olarak kart (yeşil alan içindeki)
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        shape = RoundedCornerShape(24.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFF1EB4D4)) // Mavi arkaplan
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(24.dp),
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = "Hava Durumu",
//                fontSize = 20.sp,
//                color = Color.White
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            if (weatherData != null) {
//                Text(
//                    text = "${weatherData!!.main.temp}° - ${weatherData!!.weather.firstOrNull()?.description}",
//                    fontSize = 16.sp,
//                    color = Color.White
//                )
//            } else {
//                Text("Yükleniyor...", fontSize = 14.sp, color = Color.White)
//            }
//        }
//    }
//}
//
//@SuppressLint("MissingPermission")
//suspend fun getWeather(context: Context): WeatherResponse? {
//    val fusedLocationProvider = LocationServices.getFusedLocationProviderClient(context)
//    val location = fusedLocationProvider.lastLocation.await()
//    val lat = location.latitude
//    val lon = location.longitude
//    val apiKey = "1a976f9311e0706dd23ef5e33ad6e0f7" // API anahtarın
//
//    return RetrofitInstance.api.getWeatherByCoords(lat, lon, apiKey)
//}



//package com.example.tarimasistanim
//
//import android.annotation.SuppressLint
//import android.Manifest
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.platform.LocalContext
//import com.google.accompanist.permissions.*
//import com.google.android.gms.location.LocationServices
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun WeatherCard() {
//    val context = LocalContext.current
//    val fusedLocationClient = remember {
//        LocationServices.getFusedLocationProviderClient(context)
//    }
//
//    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
//    val scope = rememberCoroutineScope()
//    var weatherInfo by remember { mutableStateOf<String?>(null) }
//
//    val weatherApi = remember {
//        Retrofit.Builder()
//            .baseUrl("https://api.openweathermap.org/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(WeatherApi::class.java)
//    }
//
//    // 🔹 İzin otomatik olarak uygulama açıldığında istensin
//    LaunchedEffect(Unit) {
//        if (!permissionState.status.isGranted) {
//            permissionState.launchPermissionRequest()
//        }
//    }
//
//    // 🔹 İzin verildiğinde otomatik veri çekilsin
//    LaunchedEffect(permissionState.status) {
//        if (permissionState.status.isGranted) {
//            getLocationAndWeather(fusedLocationClient, weatherApi, scope) { result ->
//                weatherInfo = result
//            }
//        }
//    }
//
//    // 🔹 UI
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Hava Durumu", style = MaterialTheme.typography.titleMedium)
//        Spacer(modifier = Modifier.height(16.dp))
//        weatherInfo?.let {
//            Text(text = it)
//        } ?: Text("Yükleniyor...", color = Color.Gray)
//    }
//}
//
//
//@SuppressLint("MissingPermission")
//fun getLocationAndWeather(
//    fusedLocationClient: com.google.android.gms.location.FusedLocationProviderClient,
//    weatherApi: WeatherApi,
//    scope: CoroutineScope,
//    onResult: (String) -> Unit
//) {
//    fusedLocationClient.lastLocation
//        .addOnSuccessListener { location ->
//            if (location != null) {
//                scope.launch {
//                    try {
//                        val response = weatherApi.getWeatherByCoords(
//                            lat = location.latitude,
//                            lon = location.longitude,
//                            apiKey = "3584e980ff83e92100820714fa8a1264"
//                        )
//                        val result = "${response.name} - ${response.main.temp}°C, ${response.weather.firstOrNull()?.description ?: "N/A"}"
//                        onResult(result)
//                    } catch (e: Exception) {
//                        onResult("Hava durumu alınamadı: ${e.localizedMessage}")
//                    }
//                }
//            } else {
//                onResult("Konum alınamadı.")
//            }
//        }
//        .addOnFailureListener {
//            onResult("Konum hatası: ${it.message}")
//        }
//}


package com.example.tarimasistanim

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherCard() {
    val context = LocalContext.current
    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }
    val permissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
    val scope = rememberCoroutineScope()
    var weatherInfo by remember { mutableStateOf<String?>(null) }

    val weatherApi = remember {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    // Otomatik izin iste
    LaunchedEffect(Unit) {
        if (!permissionState.status.isGranted) {
            permissionState.launchPermissionRequest()
        }
    }

    // İzin verildiyse veri çek
    LaunchedEffect(permissionState.status) {
        if (permissionState.status.isGranted) {
            getLocationAndWeather(fusedLocationClient, weatherApi, scope) { result ->
                weatherInfo = result
            }
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF003322))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hava Durumu", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            if (permissionState.status.isGranted) {
                Text(weatherInfo ?: "Yükleniyor...", fontSize = 16.sp, color = if (weatherInfo?.contains("hata") == true) Color.Red else Color.White)
            } else {
                Text("Konum izni gerekli", fontSize = 16.sp, color = Color.Red)
            }
        }
    }
}

