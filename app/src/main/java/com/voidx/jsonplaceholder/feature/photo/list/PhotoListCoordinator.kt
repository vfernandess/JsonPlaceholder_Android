package com.voidx.jsonplaceholder.feature.photo.list

import androidx.navigation.NavController
import com.voidx.jsonplaceholder.feature.home.view.HomeFragmentDirections
import com.voidx.jsonplaceholder.feature.photo.detail.PhotoDetailCoordinator
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO

class PhotoListCoordinator(private val navigation: NavController) {

    fun startFromHome() {
        val directions = HomeFragmentDirections.actionHomeFragmentToPhotoListFragment()
        navigation.navigate(directions)
    }

    fun showDetail(photo: PhotoDTO) {
        val coordinator = PhotoDetailCoordinator(navigation)
        coordinator.startFromList(photo)
    }
}