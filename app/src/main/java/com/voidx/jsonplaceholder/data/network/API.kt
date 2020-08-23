package com.voidx.jsonplaceholder.data.network

import com.voidx.jsonplaceholder.data.model.Comment
import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.data.model.Post
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("/photos")
    fun getPhotos(): Single<List<Photo>>

    @GET("/posts/{id}")
    fun getPost(@Path("id") id: Int): Single<Post>

    @GET("/posts/{id}/comments")
    fun getCommentsFromPost(@Path("id") postId: Int): Single<List<Comment>>

}