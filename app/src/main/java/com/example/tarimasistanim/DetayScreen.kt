
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetayScreen(
//    navController: NavController,
//    resId: Int,
//    detayResId: Int,
//    viewModel: SelectedItemsViewModel
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//            .verticalScroll(rememberScrollState())
//    ) {
//        // Üstte büyük görsel ve başlık + favori yıldız
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .height(300.dp)
//            .padding(16.dp)
//            .padding(top = 10.dp)
//            ) {
//            Image(
//                painter = painterResource(id = detayResId),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(RoundedCornerShape(24.dp)),
//            )
//
//            IconButton(
//                onClick = { viewModel.addItem(resId) },
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(12.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Star,
//                    contentDescription = "Favoriye Ekle",
//                    tint = Color.White
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
//            Text(
//                text = "Brokoliyle ilgili Bilgiler",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF003322)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry...",
//                fontSize = 16.sp,
//                color = Color(0xFF003322)
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Text(
//                text = "Önerilen Ekim Zamanları",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF003322)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry...",
//                fontSize = 16.sp,
//                color = Color(0xFF003322)
//            )
//        }
//    }
//
//    // Üst geri butonu sabit
//    TopAppBar(
//        title = {},
//        navigationIcon = {
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(Icons.Default.ArrowBack, contentDescription = "Geri Dön", tint = Color.White)
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF003322))
//    )
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetayScreen(
//    navController: NavController,
//    id: Int,
//    resId: Int,
//    detayResId: Int,
//    title: String,
//    description: String,
//    plantingInfo: String,
//    viewModel: SelectedItemsViewModel
//)
//
//{
//    val bilgi = DetayBilgiProvider.getBilgi(id)
//
//
//    Text(
//        text = bilgi.description,
//        fontSize = 16.sp,
//        color = Color(0xFF003322)
//    )
//
//    Text(
//        text = bilgi.plantingInfo,
//        fontSize = 16.sp,
//        color = Color(0xFF003322)
//    )
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//            .verticalScroll(rememberScrollState())
//
//    ) {
//        Spacer(modifier = Modifier.height(55.dp))
//        // Üst görsel + başlık + yıldız
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(220.dp)
//                .padding(horizontal = 16.dp)
//        ) {
//
//            Image(
//
//                painter = painterResource(id = detayResId),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(RoundedCornerShape(24.dp)),
//            )
//
//            IconButton(
//                onClick = { viewModel.addItem(resId) },
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(14.dp)
//                    .padding(bottom = 14.dp)
//
//
//            ) {
//                Icon(
//                    modifier = Modifier
//                        .height(100.dp)
//                        .width(100.dp),
//                    imageVector = Icons.Default.Star,
//                    contentDescription = "Favoriye Ekle",
//                    tint = Color.White
//                )
//            }
//        }
//
//        // Bu spacer eskiden fazlaydı, şimdi azaltıldı
//        Spacer(modifier = Modifier.height(12.dp))
//
//        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
//            Text(
//                text = "$title ile ilgili Bilgiler",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF003322)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry...",
//                fontSize = 16.sp,
//                color = Color(0xFF003322)
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Text(
//                text = "Önerilen Ekim Zamanları",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color(0xFF003322)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry...",
//                fontSize = 16.sp,
//                color = Color(0xFF003322)
//            )
//        }
//    }
//
//    TopAppBar(
//        title = {},
//        navigationIcon = {
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(Icons.Default.ArrowBack, contentDescription = "Geri Dön", tint = Color.White)
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF003322))
//    )
//}





package com.example.tarimasistanim.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.tarimasistanim.data.DetayBilgiProvider
import com.example.tarimasistanim.viewmodel.SelectedItemsViewModel


import com.example.tarimasistanim.viewmodel.DikiliBitki

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetayScreen(
    navController: NavController,
    id: Int,
    resId: Int,
    detayResId: Int,
    viewModel: SelectedItemsViewModel,
    title: String,
    description: String,
    plantingInfo: String
) {
    val bilgi = DetayBilgiProvider.getBilgi(id)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEFE5))
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(55.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(205.dp)
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = detayResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(24.dp)),
            )

            IconButton(
                onClick = {
                    viewModel.addBitki(
                        DikiliBitki(
                            id = id,
                            resId = resId,
                            detayResId = detayResId,
                            title = bilgi.title,
                            sulamaGunu = bilgi.sulamaGunu
                        )
                    )
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(14.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favoriye Ekle",
                    tint = Color.White,
                    modifier = Modifier
                        .size(100.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Text(
                text = "${bilgi.title} ile ilgili Bilgiler",
                fontSize = 20.sp,
                color = Color(0xFF003322)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = bilgi.description,
                fontSize = 16.sp,
                color = Color(0xFF003322)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Önerilen Ekim Zamanları",
                fontSize = 20.sp,
                color = Color(0xFF003322)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = bilgi.plantingInfo,
                fontSize = 16.sp,
                color = Color(0xFF003322)
            )
        }
    }

    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Geri Dön", tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF003322))
    )
}


//
//package com.example.tarimasistanim.ui
//
//import android.content.Context
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.tarimasistanim.data.DetayBilgiProvider
//import com.example.tarimasistanim.viewmodel.SelectedItemsViewModel
//import com.example.tarimasistanim.viewmodel.DikiliBitki
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetayScreen(
//    navController: NavController,
//    id: Int,
//    resId: Int,
//    detayResId: Int,
//    viewModel: SelectedItemsViewModel,
//    title: String,
//    description: String,
//    plantingInfo: String
//) {
//    val bilgi = DetayBilgiProvider.getBilgi(id)
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//            .verticalScroll(rememberScrollState())
//    ) {
//        Spacer(modifier = Modifier.height(55.dp))
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(205.dp)
//                .padding(horizontal = 16.dp)
//        ) {
//            Image(
//                painter = painterResource(id = detayResId),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(RoundedCornerShape(24.dp)),
//            )
//
//            IconButton(
//                onClick = {
//                    val bitki = DikiliBitki(
//                        id = id,
//                        resId = resId,
//                        detayResId = detayResId,
//                        title = bilgi.title,
//                        sulamaGunu = bilgi.sulamaGunu
//                    )
//                    viewModel.addBitki(bitki)
//                    viewModel.scheduleSulamaNotification(context, bitki)
//                },
//                modifier = Modifier
//                    .align(Alignment.BottomEnd)
//                    .padding(14.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Star,
//                    contentDescription = "Favoriye Ekle",
//                    tint = Color.White,
//                    modifier = Modifier
//                        .size(100.dp)
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
//            Text(
//                text = "${bilgi.title} ile ilgili Bilgiler",
//                fontSize = 20.sp,
//                color = Color(0xFF003322)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = bilgi.description,
//                fontSize = 16.sp,
//                color = Color(0xFF003322)
//            )
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Text(
//                text = "Önerilen Ekim Zamanları",
//                fontSize = 20.sp,
//                color = Color(0xFF003322)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = bilgi.plantingInfo,
//                fontSize = 16.sp,
//                color = Color(0xFF003322)
//            )
//        }
//    }
//
//    TopAppBar(
//        title = {},
//        navigationIcon = {
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(Icons.Default.ArrowBack, contentDescription = "Geri Dön", tint = Color.White)
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF003322))
//    )
//}
