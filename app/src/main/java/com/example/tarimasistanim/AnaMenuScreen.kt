//package com.example.tarimasistanim.ui
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.net.Uri
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.foundation.layout.BoxWithConstraints
//import com.example.tarimasistanim.WeatherCard
//
//@SuppressLint("UnusedBoxWithConstraintsScope")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AnaMenuScreen(navController: NavController) {
//    val context = LocalContext.current
//    WeatherCard()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//    ) {
//
//        TopAppBar(
//            title = {},
//            navigationIcon = {
//                IconButton(onClick = { /* Menü açılır burada */ }) {
//                    Icon(Icons.Default.Menu, contentDescription = "Menü", tint = Color.White)
//                }
//            },
//            colors = TopAppBarDefaults.topAppBarColors(
//                containerColor = Color(0xFF003322)
//            )
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//                .clickable {
//                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=hava+durumu"))
//                    context.startActivity(intent)
//                },
//            shape = RoundedCornerShape(24.dp),
//            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEFE5)),
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(178.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = com.example.tarimasistanim.R.drawable.havadurumu),
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
//                Text("Hava Durumu", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFF003322))
//                Spacer(modifier = Modifier.height(4.dp))
//                Text("21° Parçalı Bulutlu", fontSize = 16.sp, color = Color(0xFF003322))
//            }
//        }
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        // Responsive Butonlar (BoxWithConstraints ile)
//        BoxWithConstraints(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            val columns = if (maxWidth < 600.dp) 2 else 4
//
//            val buttonItems = listOf(
//                com.example.tarimasistanim.R.drawable.bahcem to "bahcem",
//                com.example.tarimasistanim.R.drawable.dikilecekler to "dikilecekler",
//                com.example.tarimasistanim.R.drawable.bahcezararlilari to "zararlilar",
//                com.example.tarimasistanim.R.drawable.bahcezararlilari to "yararlilar"
//            )
//
//            val rows = buttonItems.chunked(columns)
//
//            Column(
//                verticalArrangement = Arrangement.spacedBy(16.dp)
//            ) {
//                rows.forEach { row ->
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.spacedBy(16.dp)
//                    ) {
//                        row.forEach { (iconResId, route) ->
//                            Box(
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .aspectRatio(1f)
//                                    .clip(RoundedCornerShape(24.dp))
//                                    .clickable { navController.navigate(route) },
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Image(
//                                    painter = painterResource(id = iconResId),
//                                    contentDescription = null,
//                                    contentScale = ContentScale.Crop,
//                                    modifier = Modifier.fillMaxSize()
//                                )
//                            }
//                        }
//
//                        // Satırda eksik sütun varsa boşlukla doldur
//                        if (row.size < columns) {
//                            repeat(columns - row.size) {
//                                Spacer(modifier = Modifier.weight(1f))
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

package com.example.tarimasistanim.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tarimasistanim.R
import com.example.tarimasistanim.WeatherCard

@SuppressLint("UnusedBoxWithConstraintsScope")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaMenuScreen(navController: NavController) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEFE5))
    ) {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menü", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF003322)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        WeatherCard()

        Spacer(modifier = Modifier.height(32.dp))

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        {

            val columns = if (maxWidth < 600.dp) 2 else 4

            val buttonItems = listOf(
                com.example.tarimasistanim.R.drawable.bahcem to "bahcem",
                com.example.tarimasistanim.R.drawable.dikilecekler to "dikilecekler",
                com.example.tarimasistanim.R.drawable.bahcezararlilari to "bahcezararlilari",
                com.example.tarimasistanim.R.drawable.plantid to "plantid"
            )

            val rows = buttonItems.chunked(columns)

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rows.forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        row.forEach { (iconResId, route) ->
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(24.dp))
                                    .clickable { navController.navigate(route) },
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = iconResId),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }


                        if (row.size < columns) {
                            repeat(columns - row.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
//                        Button(
//                            onClick = { navController.navigate("testbildirim") },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(top = 24.dp)
//                        ) {
//                            Text("📩 Test Bildirimi Ekranı")
//                        }


                    }
                }
            }
        }
    }
}

