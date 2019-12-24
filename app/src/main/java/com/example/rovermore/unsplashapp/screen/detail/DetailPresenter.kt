package com.example.rovermore.unsplashapp.screen.detail

import com.example.rovermore.unsplashapp.core.Presenter
import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.usecase.GetPhotoUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailPresenter
    @Inject constructor(private val getPhotoUseCase: GetPhotoUseCase): Presenter<DetailPresenterView>() {

    private var view: DetailPresenterView? = null

    private val API_KEY = "750b864acc2830b60bce5d64eb60c01abebfbea24ca3530dd81c79884b74fac0"

    override fun init(view: DetailPresenterView) {
        this.view = view
        getExtras()
        getPhotoId()
    }

    private fun getExtras() {
        view?.getExtrasFromIntent()
    }

    private fun getPhotoId() {
        val photoId = view?.getPhotoId()
        photoId?.run {
            loadPhoto(photoId)
        }
    }

    private fun loadPhoto(photoId: String) {
        CoroutineScope(Dispatchers.IO).launch {

            val photo = getPhotoUseCase.bind(GetPhotoUseCase.Params(photoId, API_KEY))

            withContext(Dispatchers.Main) {
                setUpView(photo)
            }
        }
    }

    private fun setUpView(photo: Photo){
        view?.setUpView(photo)
    }
}