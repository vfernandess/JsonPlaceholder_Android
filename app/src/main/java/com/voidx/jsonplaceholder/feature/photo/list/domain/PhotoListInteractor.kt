package com.voidx.jsonplaceholder.feature.photo.list.domain

import com.voidx.jsonplaceholder.data.Mapper
import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.data.repository.PhotoRepository
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO
import io.reactivex.Single

class PhotoListInteractor(
    private val repository: PhotoRepository,
    private val mapper: Mapper<Photo, PhotoDTO>
) {

    companion object {

        const val PHOTO_THRESHOLD = 20

        const val INITIAL_ID = 0
    }

    var currentID =
        INITIAL_ID
        private set

    fun getPhotos(): Single<List<PhotoDTO>> {
        return repository
            .getPhotos(currentID,
                PHOTO_THRESHOLD
            )
            .map { photos ->
                photos
                    .map { photo -> mapper.map(photo) }
                    .run {
                        currentID = lastOrNull()?.id ?: currentID
                        this
                    }
            }
    }
}