package com.example.rovermore.unsplashapp.injection

import com.example.rovermore.unsplashapp.injection.module.client.ApiModule
import com.example.rovermore.unsplashapp.injection.module.domain.repository.ApiRepositoryModule
import com.example.rovermore.unsplashapp.injection.module.domain.service.ServiceModel
import com.example.rovermore.unsplashapp.injection.module.usecase.UnsplashUseCaseModule
import com.example.rovermore.unsplashapp.screen.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AppModule::class,
    ApiModule::class,
    ApiRepositoryModule::class,
    ServiceModel::class,
    UnsplashUseCaseModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}