package com.example.rovermore.unsplashapp.screen

import com.example.rovermore.unsplashapp.core.PresenterView
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList

interface MainPresenterView: PresenterView {

    fun onReceiveFirstPhotoListResult(photoList: MutableList<PhotoFromList>)

    fun onReceiveMoreResults(positionIndex:Int, photoList: MutableList<PhotoFromList>)
}