package com.voidx.jsonplaceholder.data

import com.voidx.jsonplaceholder.data.local.localModule
import com.voidx.jsonplaceholder.data.network.networkModule
import com.voidx.jsonplaceholder.data.repository.repositoryModule

val dataModule = listOf(networkModule, localModule, repositoryModule)