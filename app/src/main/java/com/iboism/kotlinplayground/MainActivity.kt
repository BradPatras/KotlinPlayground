package com.iboism.kotlinplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import coil.load
import com.iboism.kotlinplayground.api.ImageModel
import com.iboism.kotlinplayground.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var imageRepository: ImagesRepository

    private lateinit var binding: ActivityMainBinding
    private var imageModels = emptyList<ImageModel>()
    private var selectedIndex = 0
        get() { return field % imageModels.size }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.centerLayout.setOnClickListener { _ -> nextPhoto() }

        lifecycle.coroutineScope.launchWhenCreated {
            imageModels = imageRepository.getImages().images
            nextPhoto()
        }
    }

    private fun nextPhoto() {
        binding.centerImage.load(imageModels[selectedIndex].url) {
            crossfade(true)
        }
        binding.descriptionLabel.text = imageModels[selectedIndex].description
        selectedIndex++
    }
}
