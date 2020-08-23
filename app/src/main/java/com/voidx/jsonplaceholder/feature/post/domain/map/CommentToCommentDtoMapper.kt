package com.voidx.jsonplaceholder.feature.post.domain.map

import com.voidx.jsonplaceholder.data.Mapper
import com.voidx.jsonplaceholder.data.model.Comment
import com.voidx.jsonplaceholder.feature.post.model.CommentDTO

class CommentToCommentDtoMapper: Mapper<Comment, CommentDTO> {

    override fun map(from: Comment): CommentDTO {
        return CommentDTO().apply {
            title = from.title
            email = from.email
            body = from.body
        }
    }
}