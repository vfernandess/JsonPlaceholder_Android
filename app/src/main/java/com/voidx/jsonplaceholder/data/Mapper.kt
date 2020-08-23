package com.voidx.jsonplaceholder.data

interface Mapper<FROM, TO> {

    fun map(from: FROM): TO

}