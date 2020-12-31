package com.iboism.kotlinplayground

import com.iboism.kotlinplayground.api.ImagesApi

class ImagesRepository {
    suspend fun getImages(): ImagesModel {
        return ImagesApi.create().images()
    }
}