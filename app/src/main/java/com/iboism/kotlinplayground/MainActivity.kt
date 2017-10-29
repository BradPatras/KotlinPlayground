package com.iboism.kotlinplayground

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import dagger.Module
import dagger.Provides

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Named

@Module
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            nextPhoto()
        }
    }

    fun nextPhoto() {
        //TODO
    }

    @Provides @Named("baseUrl") fun provideBaseUrl(): String = "https://api.myjson.com/"

}
