package com.example.rovermore.unsplashapp.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rovermore.unsplashapp.R
import com.example.rovermore.unsplashapp.UnsplashApp
import com.example.rovermore.unsplashapp.domain.model.PhotoFromList
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainPresenterView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.initWith(this)

    }

    init {
        UnsplashApp.daggerAppComponent().inject(this)
    }

    override fun setPhotoListResult(photoFromList: MutableList<PhotoFromList>) {
        //TODO INTERT LIST INTO ADAPTER
    }
}
