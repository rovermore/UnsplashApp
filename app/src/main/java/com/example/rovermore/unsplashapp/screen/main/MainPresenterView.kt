package com.example.rovermore.unsplashapp.screen.main

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rovermore.unsplashapp.core.presenter.PresenterView
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList

interface MainPresenterView: PresenterView {

    fun onReceiveFirstPhotoListResult(photoList: MutableList<PhotoFromList>)

    fun onReceiveMoreResults(positionIndex:Int, photoList: MutableList<PhotoFromList>)

    fun getRecyclerView(): RecyclerView

    fun getLayoutManager(): GridLayoutManager

    fun setErrorToast()
}