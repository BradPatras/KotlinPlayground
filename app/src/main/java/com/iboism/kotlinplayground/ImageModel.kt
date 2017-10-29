package com.iboism.kotlinplayground

import javax.inject.Inject

/**
 * Created by Brad on 10/29/2017.
 */
class ImageModel @Inject constructor(
        url: String,
        description: String)