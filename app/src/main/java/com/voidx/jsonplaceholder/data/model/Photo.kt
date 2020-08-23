package com.voidx.jsonplaceholder.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Photo(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,

    @ColumnInfo(name = "thumbnailUrl")
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?,

    @ColumnInfo(name = "photoUrl")
    @SerializedName("url")
    val photoUrl: String?

)