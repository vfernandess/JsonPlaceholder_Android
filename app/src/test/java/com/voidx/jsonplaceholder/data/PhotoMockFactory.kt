package com.voidx.jsonplaceholder.data

import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.feature.photo.list.presentation.map.PhotoToPhotoDtoMapper
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO
import com.voidx.jsonplaceholder.util.TestUtil.getObjects
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response

object PhotoMockFactory {

    fun getPhotos(): Single<List<Photo>> {
        val objects: List<Photo> = getObjects("photo_list_200.json")
        return Single.just(objects)
    }

    fun getPhotosDTO(): Single<List<PhotoDTO>> {
        val objects: List<Photo> = getObjects("photo_list_200.json")
        val mapper = PhotoToPhotoDtoMapper()
        val dtos = objects.map { mapper.map(it) }
        return Single.just(dtos)
    }

    fun emptyPhotos(): Single<List<Photo>> {
        return Single.just(emptyList())
    }

    fun emptyPhotosDTO(): Single<List<PhotoDTO>> {
        return Single.just(emptyList())
    }

    fun genericErrorPhotos(): Single<List<Photo>> {
        val body = "{\"error\":\"unknown\"}".toResponseBody("application/json".toMediaTypeOrNull())
        return Single.error(HttpException(Response.error<Any>(404, body)))
    }

    fun genericErrorPhotosDTO(): Single<List<PhotoDTO>> {
        val body = "{\"error\":\"unknown\"}".toResponseBody("application/json".toMediaTypeOrNull())
        return Single.error(HttpException(Response.error<Any>(404, body)))
    }

    fun hasPhotos(exists: Boolean): Single<Boolean> {
        return Single.just(exists)
    }

}