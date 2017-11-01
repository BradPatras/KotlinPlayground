package com.iboism.kotlinplayground

import dagger.Module
import dagger.Provides

/**
 * Created by Brad on 10/31/2017.
 */
@Module
class MainModule(val mainActivity: MainActivity) {

    @Provides
    fun provideBaseUrl(): String { return "https://api.myjson.com/" }

    @Provides
    fun provideResponseHandler(): MainActivity { return mainActivity }

}