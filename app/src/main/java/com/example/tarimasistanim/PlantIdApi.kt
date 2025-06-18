package com.example.tarimasistanim.api

import com.example.tarimasistanim.model.PlantDiagnosisRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PlantIdApi {
    @Headers(
        "Content-Type: application/json",
        "Api-Key: cyH8dVeVT4ieZ7KvvXwCGryzeJXbGTl3lE9vATOG9Ctvnby1RB"
    )
    @POST("health_assessment")
    suspend fun diagnosePlant(
        @Body request: PlantDiagnosisRequest
    ): Response<ResponseBody>
}
