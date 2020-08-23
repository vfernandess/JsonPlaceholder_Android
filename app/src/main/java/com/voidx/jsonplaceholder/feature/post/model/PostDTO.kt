package com.voidx.jsonplaceholder.feature.post.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.jsonplaceholder.BR

class PostDTO: BaseObservable() {

    @get:Bindable
    var title: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @get:Bindable
    var body: String? = null
        set(value) {
            field = value
//            notifyPropertyChanged(BR.body)
        }

    @get:Bindable
    var comments: List<CommentDTO> = emptyList()
        set(value) {
            field = value
//            notifyPropertyChanged(BR.body)
        }

}