package com.example.rovermore.unsplashapp.usecase

import com.example.rovermore.unsplashapp.core.usecase.UseCaseParams
import com.example.rovermore.unsplashapp.core.usecase.UseCaseWithParams
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import com.example.rovermore.unsplashapp.domain.service.UnsplashService
import javax.inject.Inject

class GetPhotoListUseCase
    @Inject constructor(private val unsplashService: UnsplashService)
    : UseCaseWithParams<MutableList<PhotoFromList>,GetPhotoListUseCase.Params> {

    override suspend fun bind(params: GetPhotoListUseCase.Params): MutableList<PhotoFromList> {

        return unsplashService.getPhotoList(params.apiKey, params.page)
    }

    class Params(val apiKey: String, val page: String): UseCaseParams()
}