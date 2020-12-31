package com.iboism.kotlinplayground

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Brad on 10/29/2017.
 */
data class ImageModel (
        val url: String,
        val description: String)

data class ImagesModel (
        val images: List<ImageModel>,
        val title: String)