package com.voidx.jsonplaceholder.presentation

sealed class State {

    object Loading : State()

    object Empty : State()

    object Success: State()

    object Error : State()

}