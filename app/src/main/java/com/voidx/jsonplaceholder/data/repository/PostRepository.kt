package com.voidx.jsonplaceholder.data.repository

import com.voidx.jsonplaceholder.data.model.PostWithComments
import io.reactivex.Single

interface PostRepository {

    fun getPost(postId: Int): Single<PostWithComments>

}