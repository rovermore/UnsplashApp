package com.example.rovermore.unsplashapp.domain.model

import com.google.gson.annotations.SerializedName

data class Exif(
    @SerializedName("make")val brand: String?,
    val model: String?
)