package com.example.rovermore.unsplashapp.injection

import android.content.Context
import com.example.rovermore.unsplashapp.UnsplashApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: UnsplashApp) {

    @Provides
    @Singleton
    fun context(): Context = app.applicationContext

}