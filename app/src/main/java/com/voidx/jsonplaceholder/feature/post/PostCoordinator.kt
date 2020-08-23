package com.voidx.jsonplaceholder.feature.post

import androidx.navigation.NavController
import com.voidx.jsonplaceholder.feature.home.view.HomeFragmentDirections

class PostCoordinator(private val navigation: NavController) {

    fun showPostFromHome() {
        val directions = HomeFragmentDirections.actionHomeFragmentToPostWithCommentsFragment()
        navigation.navigate(directions)
    }

}