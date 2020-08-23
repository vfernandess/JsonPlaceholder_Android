package com.voidx.jsonplaceholder.feature

import com.voidx.jsonplaceholder.feature.home.homeFeatureModule
import com.voidx.jsonplaceholder.feature.photo.list.photoListModule
import com.voidx.jsonplaceholder.feature.post.postModule

val featureModule = listOf(homeFeatureModule, postModule) + photoListModule