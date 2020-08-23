package com.voidx.jsonplaceholder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.voidx.jsonplaceholder.data.local.dao.PhotoDao
import com.voidx.jsonplaceholder.data.model.Photo

@Database(
    entities = [Photo::class],
    version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun photoDao(): PhotoDao

}