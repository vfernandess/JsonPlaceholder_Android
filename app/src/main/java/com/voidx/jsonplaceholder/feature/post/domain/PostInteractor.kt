package com.voidx.jsonplaceholder.feature.post.domain

import com.voidx.jsonplaceholder.data.Mapper
import com.voidx.jsonplaceholder.data.model.Comment
import com.voidx.jsonplaceholder.data.model.Post
import com.voidx.jsonplaceholder.data.repository.PostRepository
import com.voidx.jsonplaceholder.feature.post.model.CommentDTO
import com.voidx.jsonplaceholder.feature.post.model.PostDTO
import io.reactivex.Single

class PostInteractor(
    private val repository: PostRepository,
    private val postMapper: Mapper<Post, PostDTO>,
    private val commentMapper: Mapper<Comment, CommentDTO>
) {

    fun getPost(): Single<PostDTO> {
        return repository.getPost(1).map {
            val post = postMapper.map(it.post)
            val comments = it.comments.map { comment -> commentMapper.map(comment) }
            post.comments = comments
            post
        }
    }

}