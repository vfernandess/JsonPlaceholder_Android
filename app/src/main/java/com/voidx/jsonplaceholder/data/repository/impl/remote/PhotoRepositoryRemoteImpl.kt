package com.voidx.jsonplaceholder.data.repository.impl.remote

import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.data.network.API
import com.voidx.jsonplaceholder.data.repository.PhotoRepository
import io.reactivex.Single

class PhotoRepositoryRemoteImpl(private val api: API): PhotoRepository {

    override fun getPhotos(fromID: Int, limit: Int): Single<List<Photo>> {
        return Single.just(emptyList())
    }

    override fun fetch(): Single<List<Photo>> {
        return api.getPhotos()
    }

}