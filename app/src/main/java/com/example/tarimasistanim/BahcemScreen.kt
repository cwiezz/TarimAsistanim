//package com.example.tarimasistanim.ui
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.example.tarimasistanim.viewmodel.SelectedItemsViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BahcemScreen(navController: NavController, viewModel: SelectedItemsViewModel) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//    ) {
//        TopAppBar(
//            title = {},
//            navigationIcon = {
//                IconButton(onClick = { navController.popBackStack() }) {
//                    Icon(Icons.Default.ArrowBack, contentDescription = "Geri Dön", tint = Color.White)
//                }
//            },
//            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF003322))
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        if (viewModel.dikiliBitkiler.isEmpty()) {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text("Bahçen şu anda boş!", color = Color.Gray)
//            }
//        } else {
//            Column(
//                modifier = Modifier.padding(horizontal = 16.dp),
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            ) {
//                viewModel.dikiliBitkiler.forEach { bitki ->
//                    Image(
//                        painter = painterResource(id = bitki.resId),
//                        contentDescription = bitki.title,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(80.dp)
//                            .clip(RoundedCornerShape(20.dp))
//                            .clickable {
//                                navController.navigate("sulama/${bitki.id}")
//                            },
//                        contentScale = ContentScale.Crop
//                    )
//                }
//            }
//        }
//    }
//}
package com.example.tarimasistanim.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
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
import com.example.tarimasistanim.viewmodel.SelectedItemsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BahcemScreen(navController: NavController, viewModel: SelectedItemsViewModel) {
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

        if (viewModel.dikiliBitkiler.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Bahçen şu anda boş!", color = Color.Gray)
            }
        } else {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                viewModel.dikiliBitkiler.forEach { bitki ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFF003322))
                    ) {
                        Image(
                            painter = painterResource(id = bitki.resId),
                            contentDescription = bitki.title,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clickable {
                                    navController.navigate("sulama/${bitki.id}")
                                },
                            contentScale = ContentScale.Crop
                        )

                        IconButton(onClick = { viewModel.removeBitki(bitki.id) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Kaldır",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
