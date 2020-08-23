package com.voidx.jsonplaceholder.feature

import com.voidx.jsonplaceholder.feature.home.homeFeatureModule
import com.voidx.jsonplaceholder.feature.photo.list.photoListModule

val featureModule = listOf(homeFeatureModule) + photoListModule