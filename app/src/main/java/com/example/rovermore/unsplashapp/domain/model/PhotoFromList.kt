package com.example.rovermore.unsplashapp.domain.model

import com.google.gson.annotations.SerializedName

data class PhotoFromList(
    val id: String,
    @SerializedName("urls") val photoUrls: PhotoUrls
    )