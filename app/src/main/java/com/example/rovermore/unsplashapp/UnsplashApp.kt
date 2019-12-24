package com.example.rovermore.unsplashapp

import android.app.Application
import com.example.rovermore.unsplashapp.injection.AppComponent
import com.example.rovermore.unsplashapp.injection.AppModule
import com.example.rovermore.unsplashapp.injection.DaggerAppComponent
import com.example.rovermore.unsplashapp.injection.module.client.ApiModule
import com.example.rovermore.unsplashapp.injection.module.domain.repository.ApiRepositoryModule
import com.example.rovermore.unsplashapp.injection.module.domain.service.ServiceModel
import com.example.rovermore.unsplashapp.injection.module.usecase.UnsplashUseCaseModule


class UnsplashApp: Application() {

    companion object {
        lateinit var mDaggerAppComponent: AppComponent
        fun daggerAppComponent():AppComponent = mDaggerAppComponent
    }


    override fun onCreate() {
        super.onCreate()
        mDaggerAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule())
            .apiRepositoryModule(ApiRepositoryModule())
            .serviceModel(ServiceModel())
            .unsplashUseCaseModule(UnsplashUseCaseModule())
            .build()

    }
}