package com.iboism.kotlinplayground.di

import com.iboism.kotlinplayground.api.ImagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideImagesApi(): ImagesApi {
        return ImagesApi.create()
    }
}