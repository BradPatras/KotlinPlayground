package com.iboism.kotlinplayground

import com.iboism.kotlinplayground.api.ImagesApi
import javax.inject.Inject

class ImagesRepository @Inject constructor(private val imagesApi: ImagesApi) {
    suspend fun getImages(): ImagesModel {
        return imagesApi.images()
    }
}