package com.voidx.jsonplaceholder.feature.post.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.jsonplaceholder.BR

class CommentDTO: BaseObservable() {

    @get:Bindable
    var title: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @get:Bindable
    var email: String? = null
        set(value) {
            field = value
//            notifyPropertyChanged(BR.body)
        }

    @get:Bindable
    var body: String? = null
        set(value) {
            field = value
//            notifyPropertyChanged(BR.body)
        }

}