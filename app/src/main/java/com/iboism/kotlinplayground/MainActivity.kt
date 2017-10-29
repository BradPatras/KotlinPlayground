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
    private lateinit var imageModels: List<ImageModel>
    private lateinit var pageTitle: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { _ ->
            nextPhoto()
        }
    }

    fun nextPhoto() {
        //TODO
    }

    // ImageModelRequester Providers
    @Provides @Named("baseUrl") fun provideBaseUrl(): String = "https://api.myjson.com/"

    @Provides fun provideRequesterResponseHandler(): (ImagesModel?) -> Unit {
        return {
            it?.images?.let { responseImages -> this.imageModels = responseImages }
            it?.title?.let { responseTitle -> this.pageTitle = responseTitle }
        }
    }
}
