package com.voidx.jsonplaceholder.feature.post.domain.map

import com.voidx.jsonplaceholder.data.Mapper
import com.voidx.jsonplaceholder.data.model.Post
import com.voidx.jsonplaceholder.feature.post.model.PostDTO

class PostToPostDtoMapper: Mapper<Post, PostDTO> {

    override fun map(from: Post): PostDTO {
        return PostDTO().apply {
            title = from.title
            body = from.body
        }
    }
}