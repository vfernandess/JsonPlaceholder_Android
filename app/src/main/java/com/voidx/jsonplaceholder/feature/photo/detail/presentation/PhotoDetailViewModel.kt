package com.voidx.jsonplaceholder.feature.photo.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voidx.jsonplaceholder.feature.photo.list.model.PhotoDTO

class PhotoDetailViewModel : ViewModel() {

    private val photo = MutableLiveData<PhotoDTO>()

    fun photo(): LiveData<PhotoDTO> = photo

    fun load(photo: PhotoDTO) {
        this.photo.postValue(photo)
    }

}