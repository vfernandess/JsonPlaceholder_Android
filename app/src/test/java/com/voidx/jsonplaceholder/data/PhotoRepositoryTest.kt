package com.voidx.jsonplaceholder.data

import com.voidx.jsonplaceholder.data.repository.PhotoRepository
import com.voidx.jsonplaceholder.data.repository.impl.PhotoRepositoryImpl
import com.voidx.jsonplaceholder.data.repository.impl.local.PhotoRepositoryLocal
import io.mockk.mockk
import org.junit.Before

class PhotoRepositoryTest {

    private val remoteRepository: PhotoRepository = mockk(relaxed = true)
    private val localRepository: PhotoRepositoryLocal = mockk(relaxed = true)

    private lateinit var repository: PhotoRepository

    @Before
    fun setup() {
        repository = PhotoRepositoryImpl(remoteRepository, localRepository)
    }

//    @Test
//    fun `test `() {
//
//        every { remoteRepository.fetch() } returns getPhotos()
//        every { localRepository.hasPhotos() } returns hasPhotos(false)
////        every {  }
//
//        repository
//            .getPhotos(any(), any())
//            .test()
//            .assertOf {
//
//            }
//
//
//    }

}