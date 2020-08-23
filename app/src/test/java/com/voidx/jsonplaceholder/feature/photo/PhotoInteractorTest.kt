package com.voidx.jsonplaceholder.feature.photo

import com.voidx.jsonplaceholder.data.PhotoMockFactory.emptyPhotos
import com.voidx.jsonplaceholder.data.PhotoMockFactory.genericErrorPhotos
import com.voidx.jsonplaceholder.data.PhotoMockFactory.getPhotos
import com.voidx.jsonplaceholder.data.repository.PhotoRepository
import com.voidx.jsonplaceholder.feature.photo.list.domain.PhotoListInteractor
import com.voidx.jsonplaceholder.feature.photo.list.presentation.map.PhotoToPhotoDtoMapper
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException

class PhotoInteractorTest {

    private lateinit var listInteractor: PhotoListInteractor

    private val mapper = PhotoToPhotoDtoMapper()
    private val repository: PhotoRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        listInteractor =
            PhotoListInteractor(
                repository,
                mapper
            )
    }

    @Test
    fun `check if id changes for a photo listing`() {

        every { repository.getPhotos(any(), any()) } returns getPhotos()

        listInteractor
            .getPhotos()
            .test()
            .assertNoErrors()
            .assertValue { it.size == 2 }
            .assertValue { listInteractor.currentID == 2 }
    }

    @Test
    fun `check if ID does not changes for a empty list`() {

        every { repository.getPhotos(any(), any()) } returns emptyPhotos()

        listInteractor
            .getPhotos()
            .test()
            .assertNoErrors()
            .assertValue { listInteractor.currentID == 0 }
    }

    @Test
    fun `check if ID does not changes for after success listing and next empty listing`() {

        every { repository.getPhotos(any(), any()) } returns getPhotos()

        listInteractor
            .getPhotos()
            .test()
            .assertNoErrors()
            .assertValue { listInteractor.currentID == 2 }

        every { repository.getPhotos(any(), any()) } returns emptyPhotos()

        listInteractor
            .getPhotos()
            .test()
            .assertNoErrors()
            .assertValue { listInteractor.currentID == 2 }
    }

    @Test
    fun `check if ID does not change for an error`()  {

        every { repository.getPhotos(any(), any()) } returns genericErrorPhotos()

        listInteractor
            .getPhotos()
            .test()
            .assertError(HttpException::class.java)
            .assertError { listInteractor.currentID == 0 }
            .assertNoValues()

    }

}