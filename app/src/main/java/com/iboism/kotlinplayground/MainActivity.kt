package com.iboism.kotlinplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit @Inject var imageModelRequester: ImageModelRequester

    private var imageModels = emptyList<ImageModel>()
    private var selectedIndex = 0
        get() { return field % imageModels.size }

    private val responseHandler = object : ImageModelRequester.ResponseHandler {
        override fun onResponse(imagesModel: ImagesModel?) {
            imagesModel?.images?.let { responseImages -> imageModels = responseImages }
            nextPhoto()
        }
    }

    private val requesterComponent = DaggerRequesterComponent
            .builder()
            .mainModule(MainModule(responseHandler))
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        center_layout.setOnClickListener { _ -> nextPhoto() }

        requesterComponent.inject(this)

        imageModelRequester.start()
    }

    fun nextPhoto() {
        Picasso.with(applicationContext).load(imageModels[selectedIndex].url).into(center_image)
        description_label.text = imageModels[selectedIndex].description
        selectedIndex++
    }
}
