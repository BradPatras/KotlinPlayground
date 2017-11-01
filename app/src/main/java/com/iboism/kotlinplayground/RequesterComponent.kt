package com.iboism.kotlinplayground

import dagger.Component

/**
 * Created by Brad on 10/31/2017.
 */
@Component(modules = arrayOf(MainModule::class))
interface RequesterComponent {
    fun inject(mainActivity: MainActivity)
}