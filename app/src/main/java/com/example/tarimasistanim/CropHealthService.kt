package com.example.tarimasistanim.network

import com.example.tarimasistanim.model.CropHealthRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CropHealthService {
    @Headers("Api-Key: lR5ty6Zw1TakA0Xcf0YzsMoSptOZwTJnH3SI0sXgftKdVgOt9j")
    @POST("api/v1/identification")
    suspend fun identifyCrop(@Body request: CropHealthRequest): Response<ResponseBody>
}
