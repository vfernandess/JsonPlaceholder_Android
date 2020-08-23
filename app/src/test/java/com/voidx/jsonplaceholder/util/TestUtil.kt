package com.voidx.jsonplaceholder.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.nio.charset.StandardCharsets

object TestUtil {

    inline fun <reified T> getObjects(fileName: String): List<T> {
        val json = getJson(fileName)
        val type = TypeToken.getParameterized(List::class.java, T::class.java).type
        return Gson().fromJson(json, type)
    }

    fun getJson(fileName: String): String? {
        return try {
            val classLoader = ClassLoader.getSystemClassLoader()
            val inputStream = classLoader.getResourceAsStream(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)

            inputStream.read(buffer)
            inputStream.close()

            String(buffer, StandardCharsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}