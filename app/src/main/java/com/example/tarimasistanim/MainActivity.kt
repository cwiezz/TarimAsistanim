//package com.example.tarimasistanim
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.tarimasistanim.ui.AnaMenuScreen
//import com.example.tarimasistanim.ui.theme.TarimAsistanimTheme
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            TarimAsistanimApp()
//        }
//    }
//}
//
//@Composable
//fun TarimAsistanimApp() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "ana_menu") {
//        composable("ana_menu") { AnaMenuScreen(navController) }
//        composable("bahcem") { PlaceholderScreen("Bahçem") }
//        composable("dikilecekler") { PlaceholderScreen("Dikilecekler") }
//        composable("zararlilar") { PlaceholderScreen("Bahçe Zararlıları") }
//        composable("yararlilar") { PlaceholderScreen("Bahçe Yararlıları") }
//    }
//}
//
//@Composable
//fun PlaceholderScreen(name: String) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "$name Sayfası", style = MaterialTheme.typography.headlineMedium)
//    }
//}
//package com.example.tarimasistanim
//
//import android.Manifest
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.tarimasistanim.ui.theme.TarimAsistanimTheme
//import com.google.accompanist.permissions.ExperimentalPermissionsApi
//import com.google.accompanist.permissions.rememberPermissionState
//import kotlinx.coroutines.launch
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//import retrofit2.http.Query
//import android.annotation.SuppressLint
//import android.content.pm.PackageManager
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.core.app.ActivityCompat
//import com.google.accompanist.permissions.isGranted
//import com.google.android.gms.location.LocationServices
//import kotlinx.coroutines.CoroutineScope
//
//class MainActivity : ComponentActivity() {
//
//    private val weatherApi by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://api.openweathermap.org/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(WeatherApi::class.java)
//    }
//
//    @OptIn(ExperimentalPermissionsApi::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//
//        setContent {
//            TarimAsistanimTheme {
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    var weatherInfo by remember { mutableStateOf<String?>(null) }
//                    val locationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
//                    val scope = rememberCoroutineScope()
//
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(16.dp),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        val permissionGranted = locationPermissionState.status.isGranted
//
//                        Button(onClick = {
//                            if (permissionGranted) {
//                                getLocationAndWeather(
//                                    fusedLocationClient,
//                                    weatherApi,
//                                    scope,
//                                    onResult = { result ->
//                                        weatherInfo = result
//                                    }
//                                )
//                            } else {
//                                locationPermissionState.launchPermissionRequest()
//                            }
//                        }) {
//                            Text("Hava Durumu")
//                        }
//
//
//                        Spacer(modifier = Modifier.height(24.dp))
//
//                        weatherInfo?.let {
//                            Text(text = it)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

//package com.example.tarimasistanim
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.tarimasistanim.ui.AnaMenuScreen
//import com.example.tarimasistanim.ui.theme.TarimAsistanimTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            TarimAsistanimTheme {
//                val navController = rememberNavController()
//
//                NavHost(navController = navController, startDestination = "anamenu") {
//                    composable("anamenu") {
//                        AnaMenuScreen(navController = navController)
//                    }
//                    // Diğer sayfaları da buraya eklersin
//                    // composable("dikilecekler") { DikileceklerScreen(...) }
//                }
//            }
//        }
//    }
//}

package com.example.tarimasistanim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tarimasistanim.data.DetayBilgiProvider
import com.example.tarimasistanim.ui.AnaMenuScreen
import com.example.tarimasistanim.ui.BahcemScreen
import com.example.tarimasistanim.ui.DetayScreen
import com.example.tarimasistanim.ui.DikileceklerScreen
import com.example.tarimasistanim.ui.SulamaScreen
import com.example.tarimasistanim.ui.theme.TarimAsistanimTheme
import com.example.tarimasistanim.viewmodel.SelectedItemsViewModel
import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.tarimasistanim.data.DetayBilgiProviderbz
import com.example.tarimasistanim.ui.BahceZararlilariScreen
import com.example.tarimasistanim.ui.DetayScreenbz
import com.example.tarimasistanim.ui.PlantDiagnosisScreen


class MainActivity : ComponentActivity() {
    @SuppressLint("ComposableDestinationInComposeScope")
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    100
                )
            }
        }

        super.onCreate(savedInstanceState)
        setContent {
            TarimAsistanimTheme {
                val navController = rememberNavController()
                val viewModel: SelectedItemsViewModel = viewModel()


                NavHost(navController = navController, startDestination = "anamenu") {
                    composable("anamenu") { AnaMenuScreen(navController) }
                    composable("dikilecekler") { DikileceklerScreen(navController) }
                    composable("bahcezararlilari") { BahceZararlilariScreen(navController) }
                    composable("sulama/{bitkiId}") { backStackEntry ->
                        val bitkiId = backStackEntry.arguments?.getString("bitkiId")?.toIntOrNull()
                            ?: return@composable
                        val bitki = viewModel.dikiliBitkiler.firstOrNull { it.id == bitkiId }
                            ?: return@composable
                        SulamaScreen(bitki = bitki)
                    }
                    composable("plantid") {
                        PlantDiagnosisScreen()
                    }



                    composable("bahcem") {
                        BahcemScreen(navController = navController, viewModel = viewModel)
                    }
                    composable("detay/{id}/{resId}/{detayResId}") { navBackStackEntry ->
                        val id = navBackStackEntry.arguments?.getString("id")?.toIntOrNull()
                            ?: return@composable
                        val resId = navBackStackEntry.arguments?.getString("resId")?.toIntOrNull()
                            ?: return@composable
                        val detayResId =
                            navBackStackEntry.arguments?.getString("detayResId")?.toIntOrNull()
                                ?: return@composable

                        val bilgi = DetayBilgiProvider.getBilgi(id)


                        DetayScreen(
                            navController = navController,
                            id = id,  //
                            resId = resId,
                            detayResId = detayResId,
                            title = bilgi.title,
                            description = bilgi.description,
                            plantingInfo = bilgi.plantingInfo,
                            viewModel = viewModel
                        )

                    }
                    composable("detaybz/{idbz}/{detayResIdbz}") { navBackStackEntry ->
                        val idbz = navBackStackEntry.arguments?.getString("idbz")?.toIntOrNull()
                            ?: return@composable
                        val detayResIdbz = navBackStackEntry.arguments?.getString("detayResIdbz")?.toIntOrNull()
                            ?: return@composable

                        val bilgibz = DetayBilgiProviderbz.getBilgibz(idbz)

                        DetayScreenbz(
                            navController = navController,
                            idbz = idbz,
                            detayResIdbz = detayResIdbz,
                            title = bilgibz.title,
                            descriptionbz = bilgibz.descriptionbz,
                            suggestion = bilgibz.suggestion,
                        )
                    }



                }


                }
            }

        }
    }



