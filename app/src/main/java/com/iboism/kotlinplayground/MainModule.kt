package com.iboism.kotlinplayground

import dagger.Module
import dagger.Provides

/**
 * Created by Brad on 10/31/2017.
 */
@Module
class MainModule(val responseHandler: ImageModelRequester.ResponseHandler) {

    @Provides
    fun provideResponseHandler(): ImageModelRequester.ResponseHandler { return responseHandler }

}