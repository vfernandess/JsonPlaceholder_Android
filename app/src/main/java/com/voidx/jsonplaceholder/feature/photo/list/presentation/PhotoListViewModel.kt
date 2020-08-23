package com.voidx.jsonplaceholder.feature.photo.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voidx.jsonplaceholder.data.util.disposedBy
import com.voidx.jsonplaceholder.feature.photo.list.domain.PhotoListInteractor
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO
import com.voidx.jsonplaceholder.presentation.LiveEvent
import com.voidx.jsonplaceholder.presentation.State
import com.voidx.jsonplaceholder.presentation.ext.appendItems
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PhotoListViewModel(
    private val listInteractor: PhotoListInteractor,
    private val mainThreadScheduler: Scheduler
) : ViewModel() {

    val onItemClick = LiveEvent<PhotoDTO>()

    private val photos = MutableLiveData<MutableList<PhotoDTO>>(mutableListOf())
    private val state = MutableLiveData<State>()

    private val disposables = CompositeDisposable()

    fun state(): LiveData<State> = state

    fun photos(): LiveData<List<PhotoDTO>> {
        return photos as? LiveData<List<PhotoDTO>> ?: MutableLiveData(emptyList())
    }

    fun showDetail(position: Int) {
        photos.value?.elementAt(position)?.run {
            onItemClick.postValue(this)
        }
    }

    fun load() {

        state.postValue(State.Loading)

        listInteractor
            .getPhotos()
            .observeOn(mainThreadScheduler)
            .subscribeOn(Schedulers.io())
            .subscribe({
                if (it.isEmpty() &&
                    photos.value.isNullOrEmpty() &&
                    listInteractor.currentID == PhotoListInteractor.INITIAL_ID
                ) {
                    state.postValue(State.Empty)
                    return@subscribe
                }

                state.postValue(State.Success)
                photos.appendItems(it)
            }, {
                if (photos.value.isNullOrEmpty().not()) {
                    state.postValue(State.Success)
                    return@subscribe
                }

                state.postValue(State.Error)
            })
            .disposedBy(disposables)
    }

}