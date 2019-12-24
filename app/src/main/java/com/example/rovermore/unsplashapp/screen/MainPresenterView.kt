package com.example.rovermore.unsplashapp.screen

import com.example.rovermore.unsplashapp.core.PresenterView
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList

interface MainPresenterView: PresenterView {

    fun setPhotoListResult(photoFromList: MutableList<PhotoFromList>)
}