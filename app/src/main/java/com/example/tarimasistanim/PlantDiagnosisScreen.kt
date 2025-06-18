//package com.example.tarimasistanim.ui
//
//import android.graphics.BitmapFactory
//import android.net.Uri
//import android.util.Base64
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import com.example.tarimasistanim.api.RetrofitInstance2
//import com.example.tarimasistanim.model.PlantDiagnosisRequest
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import okhttp3.ResponseBody
//import org.json.JSONObject
//import java.io.ByteArrayOutputStream
//import java.io.InputStream
//
//@Composable
//fun PlantDiagnosisScreen() {
//    val context = LocalContext.current
//
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//    var imageBitmap by remember { mutableStateOf<androidx.compose.ui.graphics.ImageBitmap?>(null) }
//    var diagnosisResult by remember { mutableStateOf("Henüz analiz yapılmadı.") }
//    var loading by remember { mutableStateOf(false) }
//
//    val imagePickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
//        if (uri != null) {
//            imageUri = uri
//
//            val inputStream = context.contentResolver.openInputStream(uri)
//            val bitmap = BitmapFactory.decodeStream(inputStream)
//            imageBitmap = bitmap?.asImageBitmap()
//            inputStream?.close()
//        }
//    }
//
//    LaunchedEffect(imageUri) {
//        imageUri?.let {
//            loading = true
//            diagnosisResult = "🧠 Analiz yapılıyor..."
//
//            val base64 = uriToBase64(context, it)
//            val result = callPlantIdApiWithRetrofit(base64)
//
//            diagnosisResult = result
//            loading = false
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFF1F1F1))
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Button(onClick = { imagePickerLauncher.launch("image/*") }) {
//            Text("📷 Fotoğraf Seç")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        imageBitmap?.let {
//            Image(bitmap = it, contentDescription = "Seçilen görsel", modifier = Modifier.size(200.dp))
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//
//        if (loading) {
//            CircularProgressIndicator()
//        } else {
//            Text(
//                text = diagnosisResult,
//                color = if (diagnosisResult.contains("❌") || diagnosisResult.contains("⚠️")) Color.Red else Color(0, 255, 53)
//            )
//        }
//    }
//}
//
//suspend fun uriToBase64(context: android.content.Context, uri: Uri): String {
//    return withContext(Dispatchers.IO) {
//        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
//        val bytes = inputStream?.readBytes()
//        inputStream?.close()
//        val outputStream = ByteArrayOutputStream()
//        outputStream.write(bytes)
//        Base64.encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)
//    }
//}
//
//suspend fun callPlantIdApiWithRetrofit(base64Image: String): String {
//    return withContext(Dispatchers.IO) {
//        try {
//            val request = PlantDiagnosisRequest(
//                images = listOf(base64Image),
//                similar_images = true,
//                health = "only"
//            )
//
//            val response = RetrofitInstance2.api.diagnosePlant(request)
//
//            if (!response.isSuccessful) {
//                val error = response.errorBody()?.string()
//                return@withContext "❌ Hata ${response.code()}\n$error"
//            }
//
//            val body = response.body()?.string() ?: return@withContext "❌ Sunucudan yanıt alınamadı."
//            val json = JSONObject(body)
//
//            val result = json.optJSONObject("result")
//                ?: return@withContext "⚠️ Yanıt çözümlenemedi."
//
//            val disease = result.optJSONObject("disease")
//                ?: return@withContext "✅ Bitki sağlıklı görünüyor (hastalık yok)."
//
//            val suggestions = disease.optJSONArray("suggestions")
//            if (suggestions == null || suggestions.length() == 0) {
//                return@withContext "✅ Bitki sağlıklı görünüyor (öneri yok)."
//            }
//
//            val firstSuggestion = suggestions.getJSONObject(0)
//            val name = firstSuggestion.optString("name", "Bilinmeyen")
//            val probability = firstSuggestion.optDouble("probability", 0.0)
//            val imageUrl = firstSuggestion
//                .optJSONArray("similar_images")
//                ?.optJSONObject(0)
//                ?.optString("url", "Görsel yok")
//
//            return@withContext """
//                ❗ Hastalık: $name
//                🎯 Olasılık: ${(probability * 100).toInt()}%
//                🖼️ Benzer Görsel: $imageUrl
//            """.trimIndent()
//        } catch (e: Exception) {
//            return@withContext "⚠️ Tanı başarısız: ${e.localizedMessage}"
//        }
//    }
//}
//
//package com.example.tarimasistanim.ui
//
//import android.graphics.BitmapFactory
//import android.net.Uri
//import android.util.Base64
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ImageBitmap
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.tarimasistanim.R
//import com.example.tarimasistanim.api.RetrofitInstance2
//import com.example.tarimasistanim.model.PlantDiagnosisRequest
//import com.example.tarimasistanim.network.PlantApiService
//import com.example.tarimasistanim.network.PlantRequest
//import com.example.tarimasistanim.network.PlantResponse
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import org.json.JSONObject
//import retrofit2.HttpException
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.io.ByteArrayOutputStream
//import java.io.InputStream
//
//
//
//@Composable
//fun PlantDiagnosisScreen() {
//    val context = LocalContext.current
//
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
//    var diagnosisResult by remember { mutableStateOf("Bilgi Alınamadı") }
//    var loading by remember { mutableStateOf(false) }
//
//    val galleryLauncher =
//        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
//            uri?.let {
//                imageUri = it
//                context.contentResolver.openInputStream(it)?.use { stream ->
//                    imageBitmap = BitmapFactory.decodeStream(stream)?.asImageBitmap()
//                }
//            }
//        }
//
//    val coroutineScope = rememberCoroutineScope()
//
//    val cameraLauncher = rememberLauncherForActivityResult(
//        ActivityResultContracts.TakePicturePreview()
//    ) { bitmap ->
//        bitmap?.let {
//            imageBitmap = it.asImageBitmap()
//            loading = true
//            diagnosisResult = "🧠 Analiz yapılıyor..."
//
//            val stream = ByteArrayOutputStream()
//            it.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, stream)
//            val base64 = Base64.encodeToString(stream.toByteArray(), Base64.NO_WRAP)
//
//            coroutineScope.launch {
//                val result = callPlantIdApiWithRetrofit(base64)
//                diagnosisResult = result
//                loading = false
//            }
//        }
//    }
//
//    LaunchedEffect(imageUri) {
//        imageUri?.let {
//            loading = true
//            diagnosisResult = "🧠 Analiz yapılıyor..."
//            val base64 = uriToBase64(context, it)
//            val result = callPlantIdApiWithRetrofit(base64)
//            diagnosisResult = result
//            loading = false
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//
//    ) {
//        // Üst bar
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(64.dp)
//                .background(Color(0xFF003322))
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//
//        // PNG Butonlar
//        Column(
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            modifier = Modifier.fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(Color(0xFF003322))
//            ) {
//                imageBitmap?.let {
//                    Image(
//                        bitmap = it,
//                        contentDescription = null,
//                        modifier = Modifier.fillMaxSize(),
//                    )
//                }
//            }
//
//
//            DiagnosisImageButton(resId = R.drawable.fotocek2) {
//                cameraLauncher.launch(null)
//            }
//            DiagnosisImageButton(resId = R.drawable.galerisec) {
//                galleryLauncher.launch("image/*")
//            }
//
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Column(
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            modifier = Modifier.fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            // AI sonucu kutusu
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(Color(0xFF003322))
//                    .padding(16.dp)
//
//            ) {
//                if (loading) {
//                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                } else {
//                    Text(text = diagnosisResult, color = Color(0xFFFFEFE5))
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun DiagnosisImageButton(resId: Int, onClick: () -> Unit) {
//    Image(
//        painter = painterResource(id = resId),
//        contentDescription = null,
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(80.dp)
//            .clickable { onClick() },
//    )
//}
//
//suspend fun uriToBase64(context: android.content.Context, uri: Uri): String {
//    return withContext(Dispatchers.IO) {
//        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
//        val bytes = inputStream?.readBytes()
//        inputStream?.close()
//        val outputStream = ByteArrayOutputStream()
//        outputStream.write(bytes)
//        Base64.encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)
//    }
//}

//suspend fun callPlantIdApiWithRetrofit(base64Image: String): String {
//    return withContext(Dispatchers.IO) {
//        try {
//            val request = PlantDiagnosisRequest(
//                images = listOf(base64Image),
//                similar_images = true,
//                health = "only"
//            )
//
//
//            val response = RetrofitInstance2.api.diagnosePlant(request)
//
//            if (!response.isSuccessful) {
//                val error = response.errorBody()?.string()
//                return@withContext "❌ Hata ${response.code()}\n$error"
//            }
//
//            val body = response.body()?.string() ?: return@withContext "❌ Sunucudan yanıt alınamadı."
//            val json = JSONObject(body)
//
//
//            val result = json.optJSONObject("result")
//                ?: return@withContext "⚠️ Yanıt çözümlenemedi."
//
//            val disease = result.optJSONObject("disease")
//                ?: return@withContext "✅ Bitki sağlıklı görünüyor (hastalık yok)."
//
//            val suggestions = disease.optJSONArray("suggestions")
//            if (suggestions == null || suggestions.length() == 0) {
//                return@withContext "✅ Bitki sağlıklı görünüyor (öneri yok)."
//            }
//
//            val firstSuggestion = suggestions.getJSONObject(0)
//            val name = firstSuggestion.optString("name", "Bilinmeyen")
//            val probability = firstSuggestion.optDouble("probability", 0.0)
//
//            return@withContext """
//                ❗ Hastalık: $name
//
//                🎯 Olasılık: ${(probability * 100).toInt()}%
//            """.trimIndent()
//
//        } catch (e: Exception) {
//            return@withContext "⚠️ Tanı başarısız: ${e.localizedMessage}"
//        }
//
//
//    }
//} orjnal

//suspend fun callPlantIdApiWithRetrofit(base64Image: String): String {
//    return withContext(Dispatchers.IO) {
//        try {
//            val request = PlantDiagnosisRequest(
//                images = listOf(base64Image),
//                similar_images = true,
//                health = "only"
//            )
//
//            val response = RetrofitInstance2.api.diagnosePlant(request)
//
//            if (!response.isSuccessful) {
//                val error = response.errorBody()?.string()
//                return@withContext "❌ Hata ${response.code()}\n$error"
//            }
//
//            val body = response.body()?.string() ?: return@withContext "❌ Sunucudan yanıt alınamadı."
//            val json = JSONObject(body)
//
//            val result = json.optJSONObject("result")
//                ?: return@withContext "⚠️ Yanıt çözümlenemedi."
//
//
//            val disease = result.optJSONObject("disease")
//                ?: return@withContext "✅ Bitki sağlıklı görünüyor (hastalık yok)."
//
//            val suggestions = disease.optJSONArray("suggestions")
//            if (suggestions == null || suggestions.length() == 0) {
//                return@withContext "✅ Bitki sağlıklı görünüyor (öneri yok)."
//            }
//
//
//            val firstSuggestion = suggestions.getJSONObject(0)
//            val name = firstSuggestion.optString("name", "Bilinmeyen")
//            val probability = firstSuggestion.optDouble("probability", 0.0)
//
//            // Özel kontrol: Model "water..." diyorsa ama güven düşükse, geçersiz say
//            if (name.equals("water excess or uneven watering", ignoreCase = true) && probability <= 0.4) {
//                return@withContext "📷 Bu görsel tanımlanamadı veya bir bitki içermiyor."
//            }
//            if (name.contains("water", ignoreCase = true) ||
//                name.contains("watering", ignoreCase = true)
//            ) {
//                return@withContext "🚫 Bu bir bitki değil gibi görünüyor veya doğru tanımlanamadı."
//            }
//            return@withContext """
//                ❗ Hastalık: $name
//
//                🎯 Olasılık: ${(probability * 100).toInt()}%
//            """.trimIndent()
//
//        } catch (e: Exception) {
//            return@withContext "⚠️ Tanı başarısız: ${e.localizedMessage}"
//        }
//    }
//}




//suspend fun callPlantIdApiWithRetrofit(base64Image: String): String {
//    return withContext(Dispatchers.IO) {
//        val service: PlantApiService
//
//        try {
//            val logging = HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//            val client = OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .build()
//
//            service = Retrofit.Builder()
//                .baseUrl("https://api.plant.id/v3/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(PlantApiService::class.java)
//
//            val request = PlantRequest(
//                images = listOf(base64Image),
//                health = "auto",
//                similar_images = true,
//                symptoms = true,
//                // **BU SATIRI EKLEYİN/GÜNCELLEYİN**
//            )
//
//            val response: PlantResponse = service.assessHealth(request)
//
//            val result = response.result
//                ?: return@withContext "⚠️ Bitki değerlendirme sonucu bulunamadı."
//
//            val diseaseSuggestions = result.disease?.suggestions
//            val symptomSuggestions = result.symptom?.suggestions
//
//            if (!diseaseSuggestions.isNullOrEmpty()) {
//                val topDisease = diseaseSuggestions.first()
//                val name = topDisease.name
//                val probability = (topDisease.probability * 100).toInt()
//
//                // **BURAYI GÜNCELLEYİN: details objesinden bilgileri almaya çalışın**
//                return@withContext """
//                    ❗ Hastalık: $name
//
//                    🎯 Olasılık: $probability%
//                """.trimIndent()
//            } else if (!symptomSuggestions.isNullOrEmpty()) {
//                val topSymptom = symptomSuggestions.first()
//                val name = topSymptom.name
//                return@withContext "✅ Bitkide olası bir belirti: $name. Ancak belirgin bir hastalık tespit edilemedi."
//            } else {
//                return@withContext "✅ Bitki sağlıklı görünüyor veya belirgin bir sorun tespit edilemedi."
//            }
//
//        } catch (e: HttpException) {
//            val code = e.code()
//            val errorBody = e.response()?.errorBody()?.string()
//            return@withContext "⚠️ Tanı başarısız: HTTP $code\nHata Detayı: $errorBody"
//        } catch (e: Exception) {
//            return@withContext "⚠️ Tanı başarısız: ${e.localizedMessage}\nLütfen internet bağlantınızı kontrol edin veya daha sonra tekrar deneyin."
//        }
//    }
//}




//package com.example.tarimasistanim.ui
//
//import android.graphics.BitmapFactory
//import android.net.Uri
//import android.util.Base64
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ImageBitmap
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.tarimasistanim.CropHealthRequest
//import com.example.tarimasistanim.R
//import com.example.tarimasistanim.RetrofitInstanceCrop
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import org.json.JSONObject
//import java.io.ByteArrayOutputStream
//import java.io.InputStream
//
//@Composable
//fun PlantDiagnosisScreen() {
//    val context = LocalContext.current
//
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
//    var diagnosisResult by remember { mutableStateOf("Bilgi Alınamadı") }
//    var loading by remember { mutableStateOf(false) }
//
//    val galleryLauncher =
//        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
//            uri?.let {
//                imageUri = it
//                context.contentResolver.openInputStream(it)?.use { stream ->
//                    imageBitmap = BitmapFactory.decodeStream(stream)?.asImageBitmap()
//                }
//            }
//        }
//
//    val coroutineScope = rememberCoroutineScope()
//
//    val cameraLauncher = rememberLauncherForActivityResult(
//        ActivityResultContracts.TakePicturePreview()
//    ) { bitmap ->
//        bitmap?.let {
//            imageBitmap = it.asImageBitmap()
//            loading = true
//            diagnosisResult = "🧠 Analiz yapılıyor..."
//
//            val stream = ByteArrayOutputStream()
//            it.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, stream)
//            val base64 = Base64.encodeToString(stream.toByteArray(), Base64.NO_WRAP)
//
//            coroutineScope.launch {
//                val result = callCropHealthApi(base64)
//                diagnosisResult = result
//                loading = false
//            }
//        }
//    }
//
//    LaunchedEffect(imageUri) {
//        imageUri?.let {
//            loading = true
//            diagnosisResult = "🧠 Analiz yapılıyor..."
//            val base64 = uriToBase64(context, it)
//            val result = callCropHealthApi(base64)
//            diagnosisResult = result
//            loading = false
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFFEFE5))
//    ) {
//        // Üst bar
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(64.dp)
//                .background(Color(0xFF003322))
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Column(
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(Color(0xFF003322))
//            ) {
//                imageBitmap?.let {
//                    Image(
//                        bitmap = it,
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            }
//
//            DiagnosisImageButton(resId = R.drawable.fotocek2) {
//                cameraLauncher.launch(null)
//            }
//            DiagnosisImageButton(resId = R.drawable.galerisec) {
//                galleryLauncher.launch("image/*")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Column(
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(Color(0xFF003322))
//                    .padding(16.dp)
//            ) {
//                if (loading) {
//                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                } else {
//                    Text(text = diagnosisResult, color = Color(0xFFFFEFE5))
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun DiagnosisImageButton(resId: Int, onClick: () -> Unit) {
//    Image(
//        painter = painterResource(id = resId),
//        contentDescription = null,
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(80.dp)
//            .clickable { onClick() }
//    )
//}
//
//suspend fun uriToBase64(context: android.content.Context, uri: Uri): String {
//    return withContext(Dispatchers.IO) {
//        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
//        val bytes = inputStream?.readBytes()
//        inputStream?.close()
//        val outputStream = ByteArrayOutputStream()
//        outputStream.write(bytes)
//        Base64.encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)
//    }
//}
//
//suspend fun callCropHealthApi(base64Image: String): String {
//    return withContext(Dispatchers.IO) {
//        try {
//            val request = CropHealthRequest(
//                images = listOf(base64Image),
//                similar_images = true
//            )
//
//            val response = RetrofitInstanceCrop.api.identifyCrop(request)
//
//            if (!response.isSuccessful) {
//                val error = response.errorBody()?.string()
//                return@withContext "❌ Hata ${response.code()}\n$error"
//            }
//
//            val body = response.body()?.string() ?: return@withContext "❌ Sunucudan yanıt alınamadı."
//            val json = JSONObject(body)
//
//            val result = json.optJSONObject("result")
//                ?: return@withContext "⚠️ Yanıt çözümlenemedi."
//
//            val taxonomy = result.optJSONObject("taxonomy")
//            val plantName = taxonomy?.optString("scientific_name", "Bilinmiyor")
//
//            val disease = result.optJSONObject("disease")
//            val diseaseName = disease?.optString("name", "Yok")
//
//            val treatment = disease?.optJSONObject("treatment")
//            val treatmentText = treatment?.optString("biological", "Bilgi yok")
//
//            return@withContext """
//                🌱 Bitki Adı: $plantName
//
//                ❗ Hastalık: $diseaseName
//
//                💊 Tedavi: $treatmentText
//            """.trimIndent()
//
//        } catch (e: Exception) {
//            return@withContext "⚠️ Tanı başarısız: ${e.localizedMessage}"
//        }
//    }
//}
// Paket ve importlar...
// Paket ve importlar...
package com.example.tarimasistanim.ui

import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tarimasistanim.R
import com.example.tarimasistanim.api.CropHealthRetrofitInstance
import com.example.tarimasistanim.model.CropHealthRequest
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.InputStream

@Composable
fun PlantDiagnosisScreen() {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var diagnosisResult by remember { mutableStateOf("Bilgi Alınamadı") }
    var loading by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            imageUri = it
            context.contentResolver.openInputStream(it)?.use { stream ->
                imageBitmap = BitmapFactory.decodeStream(stream)?.asImageBitmap()
            }
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap?.let {
            imageBitmap = it.asImageBitmap()
            loading = true
            diagnosisResult = "🧠 Analiz yapılıyor..."
            val stream = ByteArrayOutputStream()
            it.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, stream)
            val base64 = Base64.encodeToString(stream.toByteArray(), Base64.NO_WRAP)
            coroutineScope.launch {
                diagnosisResult = callCropHealthApiWithRetrofit(base64)
                loading = false
            }
        }
    }

    LaunchedEffect(imageUri) {
        imageUri?.let {
            loading = true
            diagnosisResult = "🧠 Analiz yapılıyor..."
            val base64 = uriToBase64(context, it)
            diagnosisResult = callCropHealthApiWithRetrofit(base64)
            loading = false
        }
    }

    // UI kısmı aynı kalabilir, sadece sonucu yeni API'den gelenle gösteriyoruz
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFFEFE5))
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(64.dp).background(Color(0xFF003322)))
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(200.dp)
                    .clip(RoundedCornerShape(20.dp)).background(Color(0xFF003322))
            ) {
                imageBitmap?.let {
                    Image(bitmap = it, contentDescription = null, modifier = Modifier.fillMaxSize())
                }
            }

            DiagnosisImageButton(resId = R.drawable.fotocek2) { cameraLauncher.launch(null) }
            DiagnosisImageButton(resId = R.drawable.galerisec) { galleryLauncher.launch("image/*") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth().height(200.dp)
                    .clip(RoundedCornerShape(20.dp)).background(Color(0xFF003322)).padding(16.dp)
            ) {
                if (loading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                } else {
                    Text(text = diagnosisResult, color = Color(0xFFFFEFE5))
                }
            }
        }
    }
}

@Composable
fun DiagnosisImageButton(resId: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth().height(80.dp).clickable { onClick() }
    )
}

suspend fun uriToBase64(context: android.content.Context, uri: Uri): String {
    return withContext(Dispatchers.IO) {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val bytes = inputStream?.readBytes()
        inputStream?.close()
        val outputStream = ByteArrayOutputStream()
        outputStream.write(bytes)


        Base64.encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)
    }
}

//suspend fun callCropHealthApiWithRetrofit(base64Image: String): String {
//    return withContext(Dispatchers.IO) {
//        try {
//            val request = CropHealthRequest(images = listOf(base64Image))
//            val response = CropHealthRetrofitInstance.api.identifyCrop(request)
//            if (!response.isSuccessful) {
//                return@withContext "❌ Hata: ${response.code()} – ${response.errorBody()?.string()}"
//            }
//
//            val body = response.body()?.string() ?: return@withContext "⚠️ Yanıt boş."
//            val json = JSONObject(body)
//            val result = json.optJSONObject("result") ?: return@withContext "⚠️ Yanıt çözümlenemedi."
//
//            val cropName = result.optJSONObject("crop")?.optJSONArray("suggestions")?.optJSONObject(0)?.optString("name") ?: "Tanımlanamadı"
//            val diseaseObj = result.optJSONObject("disease")?.optJSONArray("suggestions")?.optJSONObject(0)
//            val diseaseName = diseaseObj?.optString("name") ?: "Yok"
//            val treatment = diseaseObj?.optString("treatment") ?: "Bilgi yok"
//
//            return@withContext """
//                🌿 Bitki Adı/Türü: $cropName
//                ☣️ Hastalığı: $diseaseName
//                💊 Tedavisi: $treatment
//            """.trimIndent()
//
//        } catch (e: Exception) {
//            return@withContext "⚠️ İstek başarısız: ${e.localizedMessage}"
//        }
//    }
//}


suspend fun callCropHealthApiWithRetrofit(base64Image: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val request = CropHealthRequest(images = listOf(base64Image))
            val response = CropHealthRetrofitInstance.api.identifyCrop(request)
            if (!response.isSuccessful) {
                return@withContext "❌ Hata: ${response.code()} – ${response.errorBody()?.string()}"
            }

            val body = response.body()?.string() ?: return@withContext "⚠️ Yanıt boş."
            val json = JSONObject(body)
            val result = json.optJSONObject("result") ?: return@withContext "⚠️ Yanıt çözümlenemedi."

            val cropObject = result.optJSONObject("crop")
            Log.d("API_DEBUG", "Crop JSON: $cropObject")

            val cropName = cropObject
                ?.optJSONArray("suggestions")
                ?.optJSONObject(0)
                ?.optString("name") ?: "Tanımlanamadı"


            val diseaseSuggestions = result.optJSONObject("disease")
                ?.optJSONArray("suggestions")

            val diseaseTextList = mutableListOf<String>()

            diseaseSuggestions?.let {
                for (i in 0 until it.length()) {
                    val suggestion = it.optJSONObject(i)
                    val name = suggestion?.optString("name") ?: "N/A"
                    val scientificName = suggestion?.optString("scientific_name") ?: "N/A"
                    val probability = suggestion?.optDouble("probability", -1.0) ?: -1.0

                    val details = suggestion?.optJSONObject("details")
                    val language = details?.optString("language") ?: "N/A"
                    val entityId = details?.optString("entity_id") ?: "N/A"

                    diseaseTextList.add("""
                        ☣️ Hastalık: $name
                        🔬 Bilimsel Adı: $scientificName
                        📊 Olasılık: ${String.format("%.2f", probability * 100)}%
                        🌐 Dil: $language
                        🆔 Entity ID: $entityId
                    """.trimIndent())
                }
            }

            val diseasesText = if (diseaseTextList.isNotEmpty()) diseaseTextList.joinToString("\n\n") else "Hastalık bulunamadı."

            return@withContext """
                🌿 Bitki Adı/Türü: $cropName
                
                $diseasesText
            """.trimIndent()

        } catch (e: Exception) {
            return@withContext "⚠️ İstek başarısız: ${e.localizedMessage}"
        }
    }
}
