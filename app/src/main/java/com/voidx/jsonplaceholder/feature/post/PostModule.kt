package com.voidx.jsonplaceholder.feature.post

import com.voidx.jsonplaceholder.feature.post.domain.PostInteractor
import com.voidx.jsonplaceholder.feature.post.domain.map.CommentToCommentDtoMapper
import com.voidx.jsonplaceholder.feature.post.domain.map.PostToPostDtoMapper
import com.voidx.jsonplaceholder.feature.post.presentation.PostViewModel
import com.voidx.jsonplaceholder.feature.post.view.CommentAdapter
import com.voidx.jsonplaceholder.feature.post.view.PostWithCommentsFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postModule = module {

    scope<PostWithCommentsFragment> {

        scoped {
            PostInteractor(get(), PostToPostDtoMapper(), CommentToCommentDtoMapper())
        }

        scoped {
            CommentAdapter()
        }

        viewModel {
            PostViewModel(get(), get())
        }
    }
}