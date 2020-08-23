package com.voidx.jsonplaceholder.data.model

data class PostWithComments(

    val post: Post,

    val comments: List<Comment>

)