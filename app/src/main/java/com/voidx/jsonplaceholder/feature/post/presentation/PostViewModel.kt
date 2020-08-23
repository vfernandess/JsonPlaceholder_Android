package com.voidx.jsonplaceholder.feature.post.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voidx.jsonplaceholder.data.util.disposedBy
import com.voidx.jsonplaceholder.feature.post.domain.PostInteractor
import com.voidx.jsonplaceholder.feature.post.model.PostDTO
import com.voidx.jsonplaceholder.presentation.State
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostViewModel(
    private val interactor: PostInteractor,
    private val mainThreadScheduler: Scheduler
): ViewModel() {

    private val post = MutableLiveData<PostDTO>()
    private val state = MutableLiveData<State>()

    private val disposables = CompositeDisposable()

    fun state(): LiveData<State> = state

    fun post(): LiveData<PostDTO> = post

    fun load() {

        state.postValue(State.Loading)

        interactor
            .getPost()
            .observeOn(mainThreadScheduler)
            .subscribeOn(Schedulers.io())
            .subscribe({
                state.postValue(State.Success)
                post.postValue(it)
            }, {
                state.postValue(State.Error)
            })
            .disposedBy(disposables)

    }

}