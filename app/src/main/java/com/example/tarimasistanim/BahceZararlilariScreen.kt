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
fun BahceZararlilariScreen(navController: NavController) {

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
            ResimliButonbz(
                idbz = 8,
                resIdbz = R.drawable.dg,
                detayResIdbz = R.drawable.dgdetay,
                navController = navController,
            )

            ResimliButonbz(
                idbz = 9,
                resIdbz = R.drawable.ko,
                detayResIdbz = R.drawable.kodetay,
                navController = navController,
            )

            ResimliButonbz(
                idbz = 10,
                resIdbz = R.drawable.lk,
                detayResIdbz = R.drawable.lkdetay,
                navController = navController
            )
            ResimliButonbz(
                idbz = 11,
                resIdbz = R.drawable.ms,
                detayResIdbz = R.drawable.msdetay,
                navController = navController
            )
            ResimliButonbz(
                idbz = 12,
                resIdbz = R.drawable.t,
                detayResIdbz = R.drawable.tdetay,
                navController = navController
            )
            ResimliButonbz(
                idbz = 13,
                resIdbz = R.drawable.tk,
                detayResIdbz = R.drawable.tkdetay,
                navController = navController
            )
            ResimliButonbz(
                idbz = 14,
                resIdbz = R.drawable.yb,
                detayResIdbz = R.drawable.ybdetay,
                navController = navController
            )

        }
    }
}
@Composable
fun ResimliButonbz(idbz: Int, resIdbz: Int, detayResIdbz: Int, navController: NavController) {
    Image(
        painter = painterResource(id = resIdbz),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                navController.navigate("detaybz/${idbz}/${detayResIdbz}")

            },
        contentScale = ContentScale.Crop
    )
}


