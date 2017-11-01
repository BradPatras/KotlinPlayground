package com.iboism.kotlinplayground

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    lateinit @Inject var imageModelRequester: ImageModelRequester
    private var imageModels = emptyList<ImageModel>()
    private var pageTitle: String = ""
    private var selectedIndex = 0
        get() {
            return field % imageModels.size
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        center_layout.setOnClickListener { _ ->
            nextPhoto()
        }

        val requesterComponent = DaggerRequesterComponent
                .builder()
                .mainModule(MainModule(this))
                .build()
        requesterComponent.inject(this)

        imageModelRequester.start()
    }

    fun requesterResponseHandler(): ((ImagesModel?) -> Unit) = {
        it?.images?.let { responseImages -> this.imageModels = responseImages }
        it?.title?.let { responseTitle -> this.pageTitle = responseTitle }
        center_layout.invalidate()
    }

    fun nextPhoto() {
        Picasso.with(applicationContext).load(imageModels[selectedIndex].url).into(center_image)
        description_label.text = imageModels[selectedIndex].description
        selectedIndex++
        this.actionBar?.title = pageTitle
    }

}
