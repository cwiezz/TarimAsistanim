package com.example.tarimasistanim.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance2 {
    val api: PlantIdApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.plant.id/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlantIdApi::class.java)
    }
}
//package com.example.tarimasistanim.network
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitPlantService {
//    val api: PlantApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://api.plant.id/v3/")   // yalnızca bir “v3/”
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(PlantApiService::class.java)
//    }
//}
//
