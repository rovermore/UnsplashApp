package com.example.rovermore.unsplashapp.injection.module.domain.repository

import com.example.rovermore.unsplashapp.client.UnsplashApiClientImpl
import com.example.rovermore.unsplashapp.domain.repository.UnsplashApiRepository
import dagger.Module
import dagger.Provides

@Module
class ApiRepositoryModule {

    @Provides
    fun unsplashApirepository(unsplashApiClientImpl: UnsplashApiClientImpl):UnsplashApiRepository =
            UnsplashApiRepository(unsplashApiClientImpl)
}