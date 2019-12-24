package com.example.rovermore.unsplashapp.injection

import android.content.Context
import com.example.rovermore.unsplashapp.UnsplashApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: UnsplashApp) {

    @Provides
    @Singleton
    fun context(): Context = app.applicationContext

    /*private val BASE_URL = "https://api.unsplash.com"

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        return httpClient.addInterceptor(logging).build()
    }

    @Provides
    fun unsplashApiClient(client: OkHttpClient): UnsplashApiClient {

        return UnsplashApiClientImpl(
            Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(RetrofitUnsplashApiClient::class.java)

        )
    }

    @Provides
    fun unsplashApirepository(unsplashApiClientImpl: UnsplashApiClientImpl): UnsplashApiRepository =
        UnsplashApiRepository(unsplashApiClientImpl)

    @Provides
    @Singleton
    fun unsplashService(unsplashApiRepository: UnsplashApiRepository): UnsplashService =
        UnsplashService(unsplashApiRepository)

    @Provides
    fun getPhotoListUseCase(unsplashService: UnsplashService): GetPhotoListUseCase =
        GetPhotoListUseCase(unsplashService)

    @Provides
    fun getPhotoUseCase(unsplashService: UnsplashService): GetPhotoListUseCase =
        GetPhotoListUseCase(unsplashService)*/
}