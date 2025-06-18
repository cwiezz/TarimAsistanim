package com.example.tarimasistanim

data class CropHealthRequest(
    val images: List<String>,
    val similar_images: Boolean = true
)

