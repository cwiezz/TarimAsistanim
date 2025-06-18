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

import com.example.tarimasistanim.data.DetayBilgiProviderbz
import com.example.tarimasistanim.viewmodel.DikiliBitki

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetayScreenbz(
    navController: NavController,
    idbz: Int,
    detayResIdbz: Int,
    title: String,
    descriptionbz: String,
    suggestion: String
) {
    val bilgibz = DetayBilgiProviderbz.getBilgibz(idbz)


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
                painter = painterResource(id = detayResIdbz),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(24.dp)),
            )

        }

        Spacer(modifier = Modifier.height(12.dp))

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Text(
                text = "${bilgibz.title} ile ilgili Bilgiler",
                fontSize = 20.sp,
                color = Color(0xFF003322)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = bilgibz.descriptionbz,
                fontSize = 16.sp,
                color = Color(0xFF003322)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Kurtulmanın Yolları",
                fontSize = 20.sp,
                color = Color(0xFF003322)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = bilgibz.suggestion,
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




