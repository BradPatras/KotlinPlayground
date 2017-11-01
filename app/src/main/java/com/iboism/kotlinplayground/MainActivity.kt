package com.iboism.kotlinplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

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
                .mainModule(MainModule(responseHandler))
                .build()
        requesterComponent.inject(this)

        imageModelRequester.start()
    }


    fun nextPhoto() {
        Picasso.with(applicationContext).load(imageModels[selectedIndex].url).into(center_image)
        description_label.text = imageModels[selectedIndex].description
        selectedIndex++
        this.actionBar?.title = pageTitle
    }

    val responseHandler = object : ImageModelResponseHandler {
        override fun onResponse(imagesModel: ImagesModel?) {
            imagesModel?.images?.let { responseImages -> imageModels = responseImages }
            imagesModel?.title?.let { responseTitle -> pageTitle = responseTitle }
        }
    }

}
