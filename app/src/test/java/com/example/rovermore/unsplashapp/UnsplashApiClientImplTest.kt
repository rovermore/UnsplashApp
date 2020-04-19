package com.example.rovermore.unsplashapp

import com.example.rovermore.unsplashapp.client.RetrofitUnsplashApiClient
import com.example.rovermore.unsplashapp.client.UnsplashApiClientImpl
import com.example.rovermore.unsplashapp.domain.model.*
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UnsplashApiClientImplTest {

    /*@get:Rule
    var coroutinesTestRule = CoroutineTestRule()*/

    lateinit var retrofitUnsplashApiClient: RetrofitUnsplashApiClient
    lateinit var unsplashApiClientImpl: UnsplashApiClientImpl

    private val photo: Photo = PhotoMock.photo

    @Before
    fun setup() = runBlockingTest {
        MockitoAnnotations.initMocks(this)
        retrofitUnsplashApiClient = Mockito.mock(RetrofitUnsplashApiClient::class.java)
        whenever(retrofitUnsplashApiClient.getPhoto(any(), any())).thenReturn(photo)
        unsplashApiClientImpl = UnsplashApiClientImpl(retrofitUnsplashApiClient)
    }

    @Test
    fun `check if unsplashApiClientImpl asks for proper photo id to retrofitUnsplashApiClient`() = runBlockingTest {
        val id = (0..10).random().toString()
        val apiKey = "dslglfdoinvxzñoinf"
        unsplashApiClientImpl.getPhoto(id, apiKey)
        //Verify the number of calls that should happened
        verify(retrofitUnsplashApiClient, times(1)).getPhoto(id, apiKey)
    }

    @Test
    fun `if retrofitUnspalshClient return photo then unsplashApiClientImpl returns same photo`() = runBlockingTest {
        val clientPhoto = unsplashApiClientImpl.getPhoto("1","sdpofjiaofis")
        assertEquals(clientPhoto, photo)
        assertEquals(clientPhoto.id, photo.id)
        assertEquals(clientPhoto.user.name, photo.user.name)
    }
}