package com.example.rovermore.unsplashapp

import com.example.rovermore.unsplashapp.client.RetrofitUnsplashApiClient
import com.example.rovermore.unsplashapp.client.UnsplashApiClientImpl
import com.example.rovermore.unsplashapp.domain.model.Exif
import com.example.rovermore.unsplashapp.domain.model.Photo
import com.example.rovermore.unsplashapp.domain.model.PhotoUrls
import com.example.rovermore.unsplashapp.domain.model.User
import com.example.rovermore.unsplashapp.screen.detail.DetailPresenter
import com.example.rovermore.unsplashapp.usecase.GetPhotoUseCase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailPresenterTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    lateinit var getPhotoUseCase: GetPhotoUseCase
    lateinit var params: GetPhotoUseCase.Params
    lateinit var detailPresenter: DetailPresenter

    private val photo: Photo = PhotoMock.photo

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        getPhotoUseCase = Mockito.mock(GetPhotoUseCase::class.java)
        params = Mockito.mock(GetPhotoUseCase.Params::class.java)
        whenever(getPhotoUseCase.bind(params)).thenReturn(photo)
        detailPresenter = DetailPresenter(getPhotoUseCase)
    }

    @Test
    fun `if getPhotoUseCase return photo then detailPresenter returns same photo`() = runBlockingTest {
        val clientPhoto = getPhotoUseCase.bind(params)
        TestCase.assertEquals(clientPhoto, photo)
        TestCase.assertEquals(clientPhoto.id, photo.id)
        TestCase.assertEquals(clientPhoto.user.name, photo.user.name)
    }
}