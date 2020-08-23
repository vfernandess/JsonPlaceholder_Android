package com.voidx.jsonplaceholder.feature.photo.list

import androidx.navigation.NavController
import com.voidx.jsonplaceholder.data.Mapper
import com.voidx.jsonplaceholder.data.model.Photo
import com.voidx.jsonplaceholder.feature.photo.list.domain.PhotoListInteractor
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO
import com.voidx.jsonplaceholder.feature.photo.list.presentation.PhotoListViewModel
import com.voidx.jsonplaceholder.feature.photo.list.presentation.map.PhotoToPhotoDtoMapper
import com.voidx.jsonplaceholder.feature.photo.list.view.PhotoAdapter
import com.voidx.jsonplaceholder.feature.photo.list.view.PhotoListFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val photoListModule = module {

    scope<PhotoListFragment> {

        scoped {
            PhotoListInteractor(get(), get())
        }

        scoped {
            PhotoAdapter()
        }

        viewModel {
            PhotoListViewModel(get(), get())
        }

    }

    factory<Mapper<Photo, PhotoDTO>> {
        PhotoToPhotoDtoMapper()
    }

    factory { (navigation: NavController) ->
        PhotoListCoordinator(navigation)
    }

}