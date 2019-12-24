package com.example.rovermore.unsplashapp.domain.model

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: String,
    val description: String?,
    @SerializedName("urls") val photoUrls: PhotoUrls,
    val user: User,
    val exif: Exif
)