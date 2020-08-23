package com.voidx.jsonplaceholder.data.repository.impl

import com.voidx.jsonplaceholder.data.model.PostWithComments
import com.voidx.jsonplaceholder.data.repository.PostRepository
import io.reactivex.Single

class PostRepositoryImpl(private val remoteRepository: PostRepository): PostRepository {

    override fun getPost(postId: Int): Single<PostWithComments> {
        return remoteRepository.getPost(postId)
    }
}