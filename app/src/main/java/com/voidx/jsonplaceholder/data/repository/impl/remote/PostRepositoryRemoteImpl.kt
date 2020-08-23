package com.voidx.jsonplaceholder.data.repository.impl.remote

import com.voidx.jsonplaceholder.data.model.Comment
import com.voidx.jsonplaceholder.data.model.Post
import com.voidx.jsonplaceholder.data.model.PostWithComments
import com.voidx.jsonplaceholder.data.network.API
import com.voidx.jsonplaceholder.data.repository.PostRepository
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class PostRepositoryRemoteImpl(private val api: API) : PostRepository {

    override fun getPost(postId: Int): Single<PostWithComments> {

        val postSingle = api.getPost(postId)
        val commentsSingle = api.getCommentsFromPost(postId)

        return Single.zip(postSingle, commentsSingle, BiFunction { post: Post, comments: List<Comment> ->
                PostWithComments(post, comments)
            })
    }

}