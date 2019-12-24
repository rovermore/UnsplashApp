package com.example.rovermore.unsplashapp.core.usecase

interface UseCaseWithParams<T,P: UseCaseParams> {

    suspend fun bind(params: P): T
}