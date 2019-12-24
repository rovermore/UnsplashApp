package com.example.rovermore.unsplashapp.screen

import com.example.rovermore.unsplashapp.core.Presenter
import com.example.rovermore.unsplashapp.usecase.GetPhotoListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainPresenter
    @Inject constructor(private val getPhotoListUseCase: GetPhotoListUseCase): Presenter<MainPresenterView>() {

    private  var view: MainPresenterView? = null
    private var pageNumber = 1
    private var positionIndex = 0
    private val API_KEY = "750b864acc2830b60bce5d64eb60c01abebfbea24ca3530dd81c79884b74fac0"

    override fun init(view: MainPresenterView) {
        this.view = view
        loadPhotoList()
    }

    private fun loadPhotoList() {
        CoroutineScope(Dispatchers.IO).launch{

            val photoList = getPhotoListUseCase.bind(GetPhotoListUseCase.Params(API_KEY, pageNumber.toString()))

            withContext(Dispatchers.Main){
                if(pageNumber == 1) {
                    positionIndex = 0
                    view?.onReceiveFirstPhotoListResult(photoList)
                } else {
                    positionIndex += photoList.size
                    view?.onReceiveMoreResults(positionIndex, photoList)
                }
            }
        }
    }

}