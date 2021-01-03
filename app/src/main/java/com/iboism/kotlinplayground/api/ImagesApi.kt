package com.iboism.kotlinplayground.api

import com.iboism.kotlinplayground.api.adapters.JsonObjectAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.HttpUrl
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ImagesApi {

    @GET("images.json")
    suspend fun images(): ImagesModel

    companion object {
        private val BASE_URL = HttpUrl.get("https://bradpatras.github.io/kotlin-playground/")

        fun create(baseUrl: HttpUrl = BASE_URL): ImagesApi {
            val moshi = Moshi.Builder()
                    .add(JsonObjectAdapter())
                    .add(KotlinJsonAdapterFactory())
                    .build()

            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build()
                    .create(ImagesApi::class.java)
        }
    }
}