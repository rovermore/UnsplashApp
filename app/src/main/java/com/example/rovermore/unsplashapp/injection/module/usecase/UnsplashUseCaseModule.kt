package com.example.rovermore.unsplashapp.injection.module.usecase

import com.example.rovermore.unsplashapp.domain.service.UnsplashService
import com.example.rovermore.unsplashapp.usecase.GetPhotoListUseCase
import com.example.rovermore.unsplashapp.usecase.GetPhotoUseCase
import dagger.Module
import dagger.Provides

@Module
class UnsplashUseCaseModule {

    @Provides
    fun getPhotoListUseCase(unsplashService: UnsplashService): GetPhotoListUseCase =
            GetPhotoListUseCase(unsplashService)

    @Provides
    fun getPhotoUseCase(unsplashService: UnsplashService): GetPhotoUseCase =
        GetPhotoUseCase(unsplashService)
}