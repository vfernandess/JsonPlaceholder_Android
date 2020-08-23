package com.voidx.jsonplaceholder.feature.photo.list.presentation.map

import com.voidx.jsonplaceholder.data.Mapper
import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO

class PhotoToPhotoDtoMapper: Mapper<Photo, PhotoDTO> {

    override fun map(from: Photo): PhotoDTO {
        return PhotoDTO().apply {
            id = from.id
            title = from.title
            thumbnail = from.thumbnailUrl
            photo = from.photoUrl
        }
    }

}