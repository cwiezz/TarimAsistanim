package com.example.tarimasistanim.model

data class CropHealthResponse(
    val result: CropResult?
)

data class CropResult(
    val disease: CropDisease?,
    val taxonomy: CropTaxonomy?
)

data class CropDisease(
    val name: String?,
    val treatment: CropTreatment?
)

data class CropTaxonomy(
    val scientific_name: String?,
    val common_names: List<String>?
)

data class CropTreatment(
    val chemical: String?,
    val biological: String?,
    val prevention: String?
)

data class CropHealthRequest(
    val images: List<String>,
    val similar_images: Boolean = true
)