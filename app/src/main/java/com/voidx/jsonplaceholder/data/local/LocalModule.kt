package com.voidx.jsonplaceholder.data.local

import androidx.room.Room
import org.koin.dsl.module

val localModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "db").build()
    }

    factory {
        get<AppDatabase>().photoDao()
    }

}