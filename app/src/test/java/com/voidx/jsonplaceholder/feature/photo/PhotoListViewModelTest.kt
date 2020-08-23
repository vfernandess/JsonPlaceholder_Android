package com.voidx.jsonplaceholder.feature.photo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.voidx.jsonplaceholder.data.PhotoMockFactory.emptyPhotosDTO
import com.voidx.jsonplaceholder.data.PhotoMockFactory.genericErrorPhotosDTO
import com.voidx.jsonplaceholder.data.PhotoMockFactory.getPhotosDTO
import com.voidx.jsonplaceholder.feature.photo.list.domain.PhotoListInteractor
import com.voidx.jsonplaceholder.feature.photo.list.presentation.PhotoListViewModel
import com.voidx.jsonplaceholder.presentation.State
import com.voidx.jsonplaceholder.util.RxImmediateSchedulerRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.android.schedulers.AndroidSchedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PhotoListViewModelTest {

    @Rule
    @JvmField
    val rxImmediateSchedulerRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val listInteractor: PhotoListInteractor = mockk(relaxed = true)

    private lateinit var viewModel: PhotoListViewModel

    @Before
    fun setup() {
        viewModel = PhotoListViewModel(listInteractor, AndroidSchedulers.mainThread())
    }

    @Test
    fun `check successfully loading`() {

        every { listInteractor.getPhotos() } returns getPhotosDTO()

        viewModel.load()

        verify(exactly = 1) { listInteractor.getPhotos() }

        assertEquals(State.Success, viewModel.state().value)
        assertEquals(2, viewModel.photos().value?.size)
    }

    @Test
    fun `check load more items successfully`() {

        every { listInteractor.getPhotos() } returns getPhotosDTO()

        viewModel.load()

        assertEquals(State.Success, viewModel.state().value)
        assertEquals(2, viewModel.photos().value?.size)

        viewModel.load()

        assertEquals(State.Success, viewModel.state().value)
        assertEquals(4, viewModel.photos().value?.size)
    }

    @Test
    fun `check if state is marked as success even when next load does not returns values`() {

        every { listInteractor.getPhotos() } returns getPhotosDTO()

        viewModel.load()

        assertEquals(State.Success, viewModel.state().value)
        assertEquals(2, viewModel.photos().value?.size)

        every { listInteractor.getPhotos() } returns emptyPhotosDTO()

        viewModel.load()

        assertEquals(State.Success, viewModel.state().value)
        assertEquals(2, viewModel.photos().value?.size)
    }

    @Test
    fun `check if state is marked as empty only for first loading`() {

        every { listInteractor.getPhotos() } returns emptyPhotosDTO()

        viewModel.load()

        assertEquals(State.Empty, viewModel.state().value)
        assertEquals(0, viewModel.photos().value?.size)
    }

    @Test
    fun `check if error is ignored after first loading`() {

        every { listInteractor.getPhotos() } returns getPhotosDTO()

        viewModel.load()

        assertEquals(State.Success, viewModel.state().value)
        assertEquals(2, viewModel.photos().value?.size)

        every { listInteractor.getPhotos() } returns genericErrorPhotosDTO()

        viewModel.load()

        assertEquals(State.Success, viewModel.state().value)
        assertEquals(2, viewModel.photos().value?.size)
    }

    @Test
    fun `check if state is error only for first loading`() {

        every { listInteractor.getPhotos() } returns genericErrorPhotosDTO()

        viewModel.load()

        assertEquals(State.Error, viewModel.state().value)
        assertEquals(0, viewModel.photos().value?.size)
    }

}