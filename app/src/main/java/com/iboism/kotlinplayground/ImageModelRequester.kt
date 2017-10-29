package com.iboism.kotlinplayground

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

/**
 * Created by Brad on 10/29/2017.
 */
class ImageModelRequester @Inject constructor(
        val baseUrl: String,
        val responseHandler: (ImagesModel?) -> Unit) {

    fun start() {
        val rf = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = rf.create(ImageModelService::class.java)
        val call: Call<ImagesModel> = service.listImages()
        call.enqueue(object: Callback<ImagesModel> {
            override fun onResponse(call: Call<ImagesModel>?, response: Response<ImagesModel>?) {
                responseHandler(response?.body())
            }

            override fun onFailure(call: Call<ImagesModel>?, t: Throwable?) {

            }
        }

        )
    }
}

interface ImageModelService {
    @GET("bins/1finvn") fun listImages(): Call<ImagesModel>
}