package com.example.tarimasistanim.model

data class PlantDiagnosisRequest(
    val images: List<String>,
    val health: String = "only",
    val similar_images: Boolean = false,
)
