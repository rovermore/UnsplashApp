package com.example.rovermore.unsplashapp.screen.detail

import com.example.rovermore.unsplashapp.core.PresenterView
import com.example.rovermore.unsplashapp.domain.model.Photo

interface DetailPresenterView: PresenterView {

    fun getPhotoId(): String?

    fun setUpView(photo: Photo)

    fun getExtrasFromIntent()

    fun showErrorToast()
}