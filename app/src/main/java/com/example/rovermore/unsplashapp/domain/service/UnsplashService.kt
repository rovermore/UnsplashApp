package com.example.rovermore.unsplashapp.domain.service

import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import com.example.rovermore.unsplashapp.domain.repository.UnsplashApiRepository
import javax.inject.Inject

class UnsplashService
    @Inject constructor(private val unsplashApiRepository: UnsplashApiRepository) {

    suspend fun getPhotoList(apiKey: String, page: String): MutableList<PhotoFromList> =
        unsplashApiRepository.getPhotoList(apiKey, page)

    suspend fun getPhoto(id: String, apiKey: String): Photo =
        unsplashApiRepository.getPhoto(id, apiKey)
}