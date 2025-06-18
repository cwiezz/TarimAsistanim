//package com.example.tarimasistanim
//
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface WeatherApi {
//    @GET("weather")
//    suspend fun getWeatherByCoords(
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("appid") apiKey: String,
//        @Query("units") units: String = "metric",
//        @Query("lang") lang: String = "tr"
//    ): WeatherResponse
//}


//package com.example.tarimasistanim
//
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface WeatherApi {
//    @GET("data/2.5/weather")
//    suspend fun getWeatherByCoords(
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("appid") apiKey: String,
//        @Query("units") units: String = "metric",
//        @Query("lang") lang: String = "tr"
//    ): WeatherResponse
//}

//package com.example.tarimasistanim
//
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface WeatherApi {
//    @GET("data/2.5/weather?units=metric&lang=tr")
//    suspend fun getWeatherByCoords(
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("appid") apiKey: String
//    ): WeatherResponse
//}
//


//package com.example.tarimasistanim
//
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface WeatherApi {
//    @GET("data/2.5/weather")
//    suspend fun getWeatherByCoords(
//        @Query("lat") lat: Double,
//        @Query("lon") lon: Double,
//        @Query("appid") apiKey: String,
//        @Query("units") units: String = "metric",
//        @Query("lang") lang: String = "tr"
//    ): WeatherResponse
//}
//

package com.example.tarimasistanim

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeatherByCoords(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "tr"
    ): WeatherResponse
}
