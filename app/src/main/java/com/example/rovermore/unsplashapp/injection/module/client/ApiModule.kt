package com.example.rovermore.unsplashapp.injection.module.client

import com.example.rovermore.unsplashapp.client.RetrofitUnsplashApiClient
import com.example.rovermore.unsplashapp.client.UnsplashApiClientImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    private val BASE_URL = "https://api.unsplash.com"


    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient{

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        return httpClient.addInterceptor(logging).build()
    }

    @Provides
    fun retrofitInterface(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BASE_URL)
            .build()
    }



    @Provides
    fun unsplashApiClient(retrofit: Retrofit): RetrofitUnsplashApiClient {

        return UnsplashApiClientImpl(
            retrofit.create(RetrofitUnsplashApiClient::class.java)

        )
    }

}