package com.voidx.jsonplaceholder.data.model

import com.google.gson.annotations.SerializedName

data class Comment (

    @SerializedName("name")
    val title: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("body")
    val body: String

)