package com.voidx.jsonplaceholder.presentation.ext

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<MutableList<T>>.appendItems(values: List<T>) {
    val value = this.value ?: arrayListOf()
    value.addAll(values)
    postValue(value)
}