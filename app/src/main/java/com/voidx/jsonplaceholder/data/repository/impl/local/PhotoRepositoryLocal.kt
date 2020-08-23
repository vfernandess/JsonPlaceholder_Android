package com.voidx.jsonplaceholder.data.repository.impl.local

import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.data.repository.PhotoRepository
import io.reactivex.Single

interface PhotoRepositoryLocal: PhotoRepository {

    fun hasPhotos(): Single<Boolean>

    fun save(vararg photo: Photo): Single<List<Long>>

}