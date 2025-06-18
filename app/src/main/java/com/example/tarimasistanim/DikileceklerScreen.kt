package com.example.tarimasistanim.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tarimasistanim.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DikileceklerScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEFE5))
    ) {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Geri Dön", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF003322))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ResimliButon(
                id = 1,
                resId = R.drawable.domates,
                detayResId = R.drawable.domatesdetay,
                navController = navController,
            )

            ResimliButon(
                id = 2,
                resId = R.drawable.salatalik,
                detayResId = R.drawable.salatalikdetay,
                navController = navController,
            )

            ResimliButon(
                id = 3,
                resId = R.drawable.marul,
                detayResId = R.drawable.maruldetay,
                navController = navController
            )
            ResimliButon(
                id = 4,
                resId = R.drawable.patlican,
                detayResId = R.drawable.patlicandetay,
                navController = navController
            )
            ResimliButon(
                id = 5,
                resId = R.drawable.patates,
                detayResId = R.drawable.patatesdetay,
                navController = navController
            )
            ResimliButon(
                id = 6,
                resId = R.drawable.brokoli,
                detayResId = R.drawable.brokolidetay,
                navController = navController
            )
            ResimliButon(
                id = 7,
                resId = R.drawable.havuc,
                detayResId = R.drawable.havucdetay,
                navController = navController
            )

        }
    }
}

@Composable
fun ResimliButon(id: Int, resId: Int, detayResId: Int, navController: NavController) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                navController.navigate("detay/$id/$resId/$detayResId")
            },
        contentScale = ContentScale.Crop
    )
}



