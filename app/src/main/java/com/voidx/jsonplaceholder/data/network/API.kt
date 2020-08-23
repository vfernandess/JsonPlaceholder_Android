package com.voidx.jsonplaceholder.data.network

import com.voidx.jsonplaceholder.data.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface API {

    @GET("/photos")
    fun getPhotos(): Single<List<Photo>>

}