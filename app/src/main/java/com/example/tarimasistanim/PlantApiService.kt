//package com.example.tarimasistanim.network
//
//import retrofit2.http.Body
//import retrofit2.http.Headers
//import retrofit2.http.POST
//
//data class PlantRequest(
//    val images: List<String>,
//    val organs: List<String>,
//    val similar_images: Boolean = true
//)
//
//data class Disease(
//    val name: String,
//    val probability: Double,
//    val description: String,
//    val treatment: String?
//)
//
//data class HealthAssessment(
//    val diseases: List<Disease>
//)
//
//data class PlantDetails(
//    val scientific_name: String
//)
//
//data class Suggestion(
//    val plant_details: PlantDetails
//)
//
//data class PlantResponse(
//    val health_assessment: List<HealthAssessment>,
//    val suggestions: List<Suggestion>
//)
//
//interface PlantApiService {
//    @Headers(
//        "Content-Type: application/json",
//        "Api-Key: lBdq9fYYWquAX0Dmi9FUUZalIxTGnzz92Wn61xTupx97myan1g"
//    )
//    @POST("v3/health_assessment")
//    suspend fun assessHealth(@Body request: PlantRequest): PlantResponse
//}

package com.example.tarimasistanim.network

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

data class PlantRequest(
    val images: List<String>,
    val organs: List<String>,
    val similar_images: Boolean = true
)

data class Disease(
    val name: String,
    val probability: Double,
    val description: String,
    val treatment: String?
)

data class HealthAssessment(
    val diseases: List<Disease>
)

data class PlantResponse(
    val health_assessment: List<HealthAssessment>
)

interface PlantApiService {
    @Headers(
        "Content-Type: application/json",
        "Api-Key: cyH8dVeVT4ieZ7KvvXwCGryzeJXbGTl3lE9vATOG9Ctvnby1RB"
    )
    @POST("health_assessment")
    suspend fun assessHealth(
        @Query("details") details: String,       // detaylarla birlikte tedavi bilgisini iste
        @Body request: PlantRequest
    ): PlantResponse
}
//package com.example.tarimasistanim.network
//
//import retrofit2.http.Body
//import retrofit2.http.Headers
//import retrofit2.http.POST
//
//interface PlantApiService {
//    @Headers(
//        "Content-Type: application/json",
//        "Api-Key: lBdq9fYYWquAX0Dmi9FUUZalIxTGnzz92Wn61xTupx97myan1g"
//    )
//    @POST("health_assessment")
//    suspend fun assessHealth(
//        @Body request: PlantRequest
//    ): PlantResponse
//}
