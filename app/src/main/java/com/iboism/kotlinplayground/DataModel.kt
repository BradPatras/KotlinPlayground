package com.iboism.kotlinplayground

import javax.inject.Inject

/**
 * Created by Brad on 10/29/2017.
 */
data class ImageModel @Inject constructor(
        val url: String,
        val description: String)

data class ImagesModel @Inject constructor(
        val images: List<ImageModel>,
        val title: String)