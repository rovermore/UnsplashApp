package com.example.rovermore.unsplashapp.injection.module.domain.service

import com.example.rovermore.unsplashapp.domain.repository.UnsplashApiRepository
import com.example.rovermore.unsplashapp.domain.service.UnsplashService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModel {

    @Provides
    @Singleton
    fun unsplashService(unsplashApiRepository: UnsplashApiRepository): UnsplashService =
            UnsplashService(unsplashApiRepository)
}