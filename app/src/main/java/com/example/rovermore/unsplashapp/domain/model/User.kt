package com.example.rovermore.unsplashapp.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    val username: String,
    val name: String?,
    @SerializedName("portfolio_url")val portfolioUrl: String?,
    val bio: String?
)