package com.voidx.jsonplaceholder.feature.photo.detail

import com.voidx.jsonplaceholder.feature.photo.detail.presentation.PhotoDetailViewModel
import com.voidx.jsonplaceholder.feature.photo.detail.view.PhotoDetailFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val photoDetailModule = module {

    scope<PhotoDetailFragment> {

        viewModel {
            PhotoDetailViewModel()
        }

    }

}