package com.voidx.jsonplaceholder.data.repository

import com.voidx.jsonplaceholder.data.model.Photo
import io.reactivex.Single

interface PhotoRepository {

    fun getPhotos(fromID: Int, limit: Int): Single<List<Photo>>

    fun fetch(): Single<List<Photo>>

}