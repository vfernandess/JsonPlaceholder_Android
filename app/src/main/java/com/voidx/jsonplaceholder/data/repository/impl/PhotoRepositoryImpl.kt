package com.voidx.jsonplaceholder.data.repository.impl

import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.data.repository.PhotoRepository
import com.voidx.jsonplaceholder.data.repository.impl.local.PhotoRepositoryLocal
import io.reactivex.Single

class PhotoRepositoryImpl(
    private val remoteRepository: PhotoRepository,
    private val localRepository: PhotoRepositoryLocal
) : PhotoRepository {

    override fun getPhotos(fromID: Int, limit: Int): Single<List<Photo>> {
        return localRepository
            .hasPhotos()
            .flatMap { hasPhotos ->
                if (hasPhotos) {
                    localRepository.getPhotos(fromID, limit)
                } else {
                    fetch().flatMap { localRepository.getPhotos(fromID, limit) }
                }
            }
    }

    override fun fetch(): Single<List<Photo>> {
        return remoteRepository.fetch().flatMap { photos ->
            localRepository.save(*photos.toTypedArray()).map { photos }
        }
    }

}