package com.voidx.jsonplaceholder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.voidx.jsonplaceholder.data.model.Photo
import io.reactivex.Single

@Dao
interface PhotoDao {

    @Query("select * from photo where id >= :fromID limit :limit")
    fun getPhotos(fromID: Int, limit: Int): Single<List<Photo>>

    @Query("select count(*) from photo")
    fun count(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg photo: Photo): Single<List<Long>>

}