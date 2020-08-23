package com.voidx.jsonplaceholder.feature.photo

import com.voidx.jsonplaceholder.feature.photo.detail.photoDetailModule
import com.voidx.jsonplaceholder.feature.photo.list.photoListModule

val photoFeatureModule = listOf(photoListModule, photoDetailModule)