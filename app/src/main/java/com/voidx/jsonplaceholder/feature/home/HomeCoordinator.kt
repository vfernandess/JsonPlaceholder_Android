package com.voidx.jsonplaceholder.feature.home

import androidx.navigation.NavController
import com.voidx.jsonplaceholder.feature.photo.list.PhotoListCoordinator
import com.voidx.jsonplaceholder.feature.post.PostCoordinator

class HomeCoordinator(private val navigation: NavController) {

    fun showPhotos() {
        val coordinator = PhotoListCoordinator(navigation)
        coordinator.startFromHome()
    }

    fun showPosts() {
        val coordinator = PostCoordinator(navigation)
        coordinator.showPostFromHome()
    }

}