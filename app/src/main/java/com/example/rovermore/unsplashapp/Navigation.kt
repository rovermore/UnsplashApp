package com.example.rovermore.unsplashapp

import android.app.Activity
import android.content.Intent
import com.example.rovermore.unsplashapp.screen.detail.DetailActivity

fun Activity.routeToDetailActivity(photoId: String){
    val intent = Intent(this,DetailActivity::class.java)
    intent.putExtra(DetailActivity.PHOTO_ID, photoId)
    startActivity(intent)
}