package com.example.rovermore.unsplashapp.usecase

import com.example.rovermore.unsplashapp.core.usecase.UseCaseParams
import com.example.rovermore.unsplashapp.core.usecase.UseCaseWithParams
import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.service.UnsplashService
import javax.inject.Inject

class GetPhotoUseCase
    @Inject constructor(private val unsplashService: UnsplashService): UseCaseWithParams<Photo,GetPhotoUseCase.Params> {

    override suspend fun bind(params: GetPhotoUseCase.Params): Photo {
        return unsplashService.getPhoto(params.id, params.apiKey)
    }

    class Params(val id: String, val apiKey: String): UseCaseParams()
}