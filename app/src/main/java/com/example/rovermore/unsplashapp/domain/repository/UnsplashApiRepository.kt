package com.example.rovermore.unsplashapp.domain.repository

import com.example.rovermore.unsplashapp.client.UnsplashApiClientImpl
import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import javax.inject.Inject

class UnsplashApiRepository
    @Inject constructor(private val unsplashApiClientImpl: UnsplashApiClientImpl) {

    suspend fun getPhotoList(apiKey: String, page: String): MutableList<PhotoFromList> =
        unsplashApiClientImpl.getPhotosList(apiKey, page)

    suspend fun getPhoto(id: String, apiKey: String): Photo =
        unsplashApiClientImpl.getPhoto(id, apiKey)
}