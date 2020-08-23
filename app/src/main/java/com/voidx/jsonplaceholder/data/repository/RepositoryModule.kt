package com.voidx.jsonplaceholder.data.repository

import com.voidx.jsonplaceholder.data.repository.impl.PhotoRepositoryImpl
import com.voidx.jsonplaceholder.data.repository.impl.local.PhotoRepositoryLocalImpl
import com.voidx.jsonplaceholder.data.repository.impl.remote.PhotoRepositoryRemoteImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<PhotoRepository> {
        val local = PhotoRepositoryLocalImpl(get())
        val remote = PhotoRepositoryRemoteImpl(get())
        PhotoRepositoryImpl(remote, local)
    }

}