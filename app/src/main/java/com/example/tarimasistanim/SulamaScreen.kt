//package com.example.tarimasistanim.ui
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.tarimasistanim.viewmodel.DikiliBitki
//
//@Composable
//fun SulamaScreen(bitki: DikiliBitki) {
////    val gunFarki = ((System.currentTimeMillis() - bitki.ekimTarihi) / (1000 * 60 * 60 * 24)).toInt()
////    val kalanGun = bitki.sulamaGunu - (gunFarki % bitki.sulamaGunu)
//    val saniyeFarki = ((System.currentTimeMillis() - bitki.ekimTarihi) / 1000).toInt()
//    val kalanSaniye = bitki.sulamaGunu - (saniyeFarki % bitki.sulamaGunu)
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//            .padding(24.dp)
//    ) {
//        Text(text = "🌿 ${bitki.title}", fontSize = 28.sp)
//        Spacer(modifier = Modifier.height(12.dp))
//        Text("Bu bitki her ${bitki.sulamaGunu} günde bir sulanmalıdır.", fontSize = 18.sp)
//
//        Spacer(modifier = Modifier.height(12.dp))
//        if (kalanSaniye == 0) {
//            Text("💧 Bugün sulama günü!", color = Color.Red, fontSize = 20.sp)
//        } else {
//            Text("Bir sonraki sulama için $kalanSaniye gün kaldı.", fontSize = 18.sp)
//        }
//    }
//}

//package com.example.tarimasistanim.ui
//
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Context
//import android.os.Build
//import android.util.Log
//import android.content.pm.PackageManager
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import androidx.core.content.ContextCompat
//import com.example.tarimasistanim.R
//import com.example.tarimasistanim.viewmodel.DikiliBitki
//
//@Composable
//fun SulamaScreen(bitki: DikiliBitki) {
//    val saniyeFarki = ((System.currentTimeMillis() - bitki.ekimTarihi) / 1000).toInt()
//    val kalanSaniye = bitki.sulamaGunu - (saniyeFarki % bitki.sulamaGunu)
//    val context = LocalContext.current
//
//    LaunchedEffect(kalanSaniye) {
//        if (kalanSaniye == 0) {
//            Log.d("BILDIRIM", "Bildirimi gönderiyorum")
//            showNotification(
//                context = context,
//                title = "💧 Sulama Zamanı!",
//                message = "${bitki.title} sulanmalı!"
//            )
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//            .padding(24.dp)
//    ) {
//        Text(text = "🌿 ${bitki.title}", fontSize = 28.sp)
//        Spacer(modifier = Modifier.height(12.dp))
//        Text("Bu bitki her ${bitki.sulamaGunu} saniyede bir sulanmalıdır.", fontSize = 18.sp)
//
//        Spacer(modifier = Modifier.height(12.dp))
//        if (kalanSaniye == 0) {
//            Text("💧 Sulama zamanı!", color = Color.Red, fontSize = 20.sp)
//        } else {
//            Text("⏳ $kalanSaniye saniye sonra sulama zamanı.", fontSize = 18.sp)
//        }
//    }
//}
//
//fun showNotification(context: Context, title: String, message: String) {
//    val channelId = "sulama_bildirim_kanali"
//    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//        val permissionGranted = ContextCompat.checkSelfPermission(
//            context,
//            android.Manifest.permission.POST_NOTIFICATIONS
//        ) == PackageManager.PERMISSION_GRANTED
//
//        if (!permissionGranted) {
//            Log.w("BILDIRIM", "Bildirim izni verilmemiş, gönderilmeyecek.")
//            return
//        }
//    }
//
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        val channel = NotificationChannel(
//            channelId,
//            "Sulama Bildirimleri",
//            NotificationManager.IMPORTANCE_HIGH
//        ).apply {
//            description = "Bitki sulama zamanı bildirimleri"
//        }
//        notificationManager.createNotificationChannel(channel)
//    }
//
//    val builder = NotificationCompat.Builder(context, channelId)
//        .setSmallIcon(R.drawable.ic_launcher_foreground)
//        .setContentTitle(title)
//        .setContentText(message)
//        .setPriority(NotificationCompat.PRIORITY_HIGH)
//
//    NotificationManagerCompat.from(context).notify(System.currentTimeMillis().toInt(), builder.build())
//}

package com.example.tarimasistanim.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarimasistanim.R
import com.example.tarimasistanim.util.NotificationUtil.showNotification
import com.example.tarimasistanim.viewmodel.DikiliBitki
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SulamaScreen(bitki: DikiliBitki) {
    val context = LocalContext.current
    val currentTime = System.currentTimeMillis()
    val saniyeFarki = ((currentTime - bitki.ekimTarihi) / 1000).toInt()
    val initialKalanSaniye = bitki.sulamaGunu - (saniyeFarki % bitki.sulamaGunu)

    var kalanSaniye by remember { mutableStateOf(initialKalanSaniye) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L) // Her saniye bekle
            kalanSaniye = if (kalanSaniye > 0) kalanSaniye - 1 else bitki.sulamaGunu - 1

            if (kalanSaniye == 0) {
                Log.d("BILDIRIM", "Bildirimi gönderiyorum")
                showNotification(
                    context = context,
                    title = "💧 Sulama Zamanı!",
                    message = "${bitki.title} sulanmalı!"
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEFE5))
            .padding(24.dp)
    ) {
        Text(text = "🌿 ${bitki.title}", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Bu bitki her ${bitki.sulamaGunu} saniyede bir sulanmalıdır.", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(12.dp))

        if (kalanSaniye == 0) {
            Text("💧 Sulama zamanı!", color = Color.Red, fontSize = 20.sp)
        } else {
            Text("⏳ $kalanSaniye saniye sonra sulama zamanı.", fontSize = 18.sp)
        }
    }
}

