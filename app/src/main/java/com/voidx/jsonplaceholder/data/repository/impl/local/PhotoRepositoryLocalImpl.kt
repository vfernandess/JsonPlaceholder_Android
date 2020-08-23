package com.voidx.jsonplaceholder.data.repository.impl.local

import com.voidx.jsonplaceholder.data.local.dao.PhotoDao
import com.voidx.jsonplaceholder.data.model.Photo
import io.reactivex.Single

class PhotoRepositoryLocalImpl(private val photoDao: PhotoDao): PhotoRepositoryLocal {

    override fun hasPhotos(): Single<Boolean> {
        return photoDao.count().map { it > 0 }
    }

    override fun save(vararg photo: Photo): Single<List<Long>> {
        return photoDao.save(*photo)
    }

    override fun getPhotos(fromID: Int, limit: Int): Single<List<Photo>> {
        return photoDao.getPhotos(fromID, limit)
    }

    override fun fetch(): Single<List<Photo>> {
        return photoDao.getPhotos(0, Int.MAX_VALUE)
    }
}