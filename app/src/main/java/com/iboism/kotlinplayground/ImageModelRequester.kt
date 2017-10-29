package com.iboism.kotlinplayground

import retrofit2.Call
import retrofit2.http.GET
import javax.inject.Inject

/**
 * Created by Brad on 10/29/2017.
 */
class ImageModelRequester @Inject constructor(
        baseUrl: String){
}

interface ImageModelService {
    @GET("bins/1finvn") fun listImages(): Call<List<ImageModel>>
}