package com.example.rovermore.unsplashapp

import com.example.rovermore.unsplashapp.domain.model.Exif
import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoUrls
import com.example.rovermore.unsplashapp.domain.model.User

object PhotoMock {
    val photoUrls = PhotoUrls("regularUr.com","smallUrl.com","thumbUrl.com")
    val user = User("rafanadal","Rafa","portfolioUrl.com","Great tenis player")
    val exif = Exif("Cannon","EOS500")
    val photo = Photo("1","test",photoUrls, user, exif)
}