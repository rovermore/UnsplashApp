package com.example.rovermore.unsplashapp.core.presenter

abstract class Presenter<V: PresenterView> {

    fun initWith(presenterView: V){
        init(presenterView)
    }

    protected abstract fun init(view: V)
}