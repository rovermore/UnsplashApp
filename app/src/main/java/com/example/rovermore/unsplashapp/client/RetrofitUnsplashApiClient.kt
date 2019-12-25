package com.example.rovermore.unsplashapp.client

import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitUnsplashApiClient {

    @GET("/photos")
    suspend fun getPhotosList(
        @Query("client_id") apiKey: String,
        @Query("page") page: String)
            : MutableList<PhotoFromList>


    @GET("/photos/{id}")
    suspend fun getPhoto(@Path("id") photoId: String,
                        @Query("client_id") apiKey: String)
            : Photo
}