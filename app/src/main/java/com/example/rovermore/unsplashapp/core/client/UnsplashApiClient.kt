package com.example.rovermore.unsplashapp.core.client

import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList

interface UnsplashApiClient {

    suspend fun getPhotoList(apiKey: String, page: String): MutableList<PhotoFromList>

    suspend fun getPhoto(id: String, apiKey: String): Photo
}