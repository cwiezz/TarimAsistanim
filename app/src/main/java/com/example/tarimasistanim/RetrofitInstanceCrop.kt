package com.example.tarimasistanim.api

import com.example.tarimasistanim.network.CropHealthService
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

object CropHealthRetrofitInstance {
    val api: CropHealthService by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        Retrofit.Builder()
            .baseUrl("https://crop.kindwise.com/")
            .addConverterFactory(GsonConverterFactory.create())  // Bunu ekliyoruz
            .client(client)
            .build()
            .create(CropHealthService::class.java)
    }
}

