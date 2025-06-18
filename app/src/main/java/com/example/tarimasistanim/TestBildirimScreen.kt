package com.example.tarimasistanim.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.tarimasistanim.R

@Composable
fun TestBildirimScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Test Bildirim Ekranı", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val izin = ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED

            Log.d("BILDIRIM", "İzin kontrol sonucu: $izin")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !izin) {
                Log.w("BILDIRIM", "Bildirim izni verilmemiş, gönderilmeyecek")
                return@Button
            }

            val channelId = "test_bildirim_kanali"
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    channelId,
                    "Test Bildirim Kanalı",
                    NotificationManager.IMPORTANCE_HIGH
                ).apply {
                    description = "Test amaçlı kanal"
                }
                notificationManager.createNotificationChannel(channel)
            }

            val builder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("🎉 Test Başarılı")
                .setContentText("Bu bir test bildirimidir.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)

            NotificationManagerCompat.from(context)
                .notify(System.currentTimeMillis().toInt(), builder.build())

            Log.d("BILDIRIM", "Test bildirimi gönderildi")
        }) {
            Text("📩 Test Bildirimi Gönder")
        }
    }
}
