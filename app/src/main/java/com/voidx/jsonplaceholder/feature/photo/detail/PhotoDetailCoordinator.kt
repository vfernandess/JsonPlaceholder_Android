package com.voidx.jsonplaceholder.feature.photo.detail

import androidx.navigation.NavController
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO
import com.voidx.jsonplaceholder.feature.photo.list.view.PhotoListFragmentDirections

class PhotoDetailCoordinator(private val navigation: NavController) {

    fun startFromList(photo: PhotoDTO) {
            val direction =
                PhotoListFragmentDirections.actionPhotoListFragmentToPhotoDetailFragment(photo)
            navigation.navigate(direction)
    }

}