package com.example.rovermore.unsplashapp.client

import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitUnsplashApiClient {

    //list URL: https://api.unsplash.com/photos?client_id=750b864acc2830b60bce5d64eb60c01abebfbea24ca3530dd81c79884b74fac0;page=3

    @GET("/photos")
    suspend fun getPhotosList(
        @Query("client_id") apiKey: String = "750b864acc2830b60bce5d64eb60c01abebfbea24ca3530dd81c79884b74fac0",
        @Query("page") page: String)
            : MutableList<PhotoFromList>

    //photo URL: https://api.unsplash.com/photos/SmhnJ4oP7IE?client_id=750b864acc2830b60bce5d64eb60c01abebfbea24ca3530dd81c79884b74fac0

    @GET("/photos/{id}")
    suspend fun getPhoto(@Path("id") photoId: String,
                        @Query("client_id") apiKey: String = "750b864acc2830b60bce5d64eb60c01abebfbea24ca3530dd81c79884b74fac0")
            : Photo
}