package com.voidx.jsonplaceholder.feature.home

import androidx.navigation.NavController
import com.voidx.jsonplaceholder.feature.photo.list.PhotoListCoordinator

class HomeCoordinator(private val navigation: NavController) {

    fun showPhotos() {
        val coordinator = PhotoListCoordinator(navigation)
        coordinator.startFromHome()
    }

    fun showPosts() {
    }

}