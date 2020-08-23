package com.voidx.jsonplaceholder.data.local

import androidx.room.Room
import com.voidx.jsonplaceholder.BuildConfig
import org.koin.dsl.module

val localModule = module {

    single {
        if (BuildConfig.BUILD_TYPE == "mock") {
            Room.inMemoryDatabaseBuilder(get(), AppDatabase::class.java).build()
        } else {
            Room.databaseBuilder(get(), AppDatabase::class.java, "db").build()
        }
    }

    factory {
        get<AppDatabase>().photoDao()
    }

}