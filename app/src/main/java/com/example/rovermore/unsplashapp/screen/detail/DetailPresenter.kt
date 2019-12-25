package com.example.rovermore.unsplashapp.screen.detail

import com.example.rovermore.unsplashapp.BuildConfig
import com.example.rovermore.unsplashapp.core.presenter.Presenter
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

    private val API_KEY = BuildConfig.API_KEY

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

            try {
                val photo = getPhotoUseCase.bind(GetPhotoUseCase.Params(photoId, API_KEY))

                withContext(Dispatchers.Main) {
                    setUpView(photo)
                }
            } catch (e: Exception){
                withContext(Dispatchers.Main){
                    view?.showErrorToast()
                }
            }
        }
    }

    private fun setUpView(photo: Photo){
        view?.setUpView(photo)
    }
}