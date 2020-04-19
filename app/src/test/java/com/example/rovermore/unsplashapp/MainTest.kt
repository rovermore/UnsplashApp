package com.example.rovermore.unsplashapp

import com.example.rovermore.unsplashapp.domain.model.*
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainTest {

    @Mock
    lateinit var photo: Photo
    lateinit var photoUrls: PhotoUrls
    lateinit var user: User
    lateinit var exif: Exif

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        setUpPhotoMock()
    }

    private fun setUpPhotoMock() {
        photoUrls = PhotoUrls("regularUr.com","smallUrl.com","thumbUrl.com")
        user = User("rafanadal","Rafa","portfolioUrl.com","Great tenis player")
        exif = Exif("Cannon","EOS500")
        photo = Photo("1","test",photoUrls, user, exif)
    }

    @Test
    fun `objects are correct instance of their classes`() {
        assertThat(user).isInstanceOf(User::class.java)
        assertThat(exif).isInstanceOf(Exif::class.java)
        assertThat(photoUrls).isInstanceOf(PhotoUrls::class.java)
        assertThat(photo).isInstanceOf(Photo::class.java)
    }
}