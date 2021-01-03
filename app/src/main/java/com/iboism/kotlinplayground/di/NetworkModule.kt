package com.iboism.kotlinplayground.di

import com.iboism.kotlinplayground.api.ImagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideImagesApi(): ImagesApi {
        return ImagesApi.create()
    }
}