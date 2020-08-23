package com.voidx.jsonplaceholder.feature.photo.list.model

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.jsonplaceholder.BR

class PhotoDTO() : BaseObservable(), Parcelable {

    var id: Int = -1

    @get:Bindable
    var title: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @get:Bindable
    var thumbnail: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.thumbnail)
        }

    @get:Bindable
    var photo: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.photo)
        }

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        title = parcel.readString()
        thumbnail = parcel.readString()
        photo = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(thumbnail)
        parcel.writeString(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotoDTO> {
        override fun createFromParcel(parcel: Parcel): PhotoDTO {
            return PhotoDTO(parcel)
        }

        override fun newArray(size: Int): Array<PhotoDTO?> {
            return arrayOfNulls(size)
        }
    }

}