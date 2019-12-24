package com.example.rovermore.unsplashapp.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rovermore.unsplashapp.R
import com.example.rovermore.unsplashapp.UnsplashApp
import com.example.rovermore.unsplashapp.usecase.GetPhotoUseCase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getPhotoUseCase: GetPhotoUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(IO).launch{

            val photo = getPhotoUseCase.bind(GetPhotoUseCase.Params("SmhnJ4oP7IE", "750b864acc2830b60bce5d64eb60c01abebfbea24ca3530dd81c79884b74fac0"))

            withContext(Dispatchers.Main){
                textView.text = photo.description
            }
        }
    }

    init {
        UnsplashApp.daggerAppComponent().inject(this)
    }
}
