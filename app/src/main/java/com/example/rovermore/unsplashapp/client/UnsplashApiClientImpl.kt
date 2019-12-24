package com.example.rovermore.unsplashapp.client

import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import javax.inject.Inject

class UnsplashApiClientImpl
    @Inject constructor(private val retrofitUnsplashApiClient: RetrofitUnsplashApiClient):
    RetrofitUnsplashApiClient{


    override suspend fun getPhotosList(apiKey: String, page: String): MutableList<PhotoFromList> {
        return retrofitUnsplashApiClient.getPhotosList(apiKey, page)
    }


    override suspend fun getPhoto(id: String, apiKey: String): Photo =
            retrofitUnsplashApiClient.getPhoto(id, apiKey)


}