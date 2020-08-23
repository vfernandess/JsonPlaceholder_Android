package com.voidx.jsonplaceholder.feature.photo.list

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.voidx.jsonplaceholder.util.ImmediateSchedulersRule
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PhotoListFragmentUiTest {

    @Rule
    @JvmField
    val immediateSchedulersRule = ImmediateSchedulersRule()

    private val mockWebServer = MockWebServer().apply {
        try {
            start(8080)
        } catch (e: Exception) {
            Log.e("MockWebServer", e.message, e)
            e.printStackTrace()
        }
    }

    private lateinit var robot: PhotoListRobot

    @Before
    fun setUp() {
        robot = PhotoListRobot(mockWebServer)
    }

    @Test
    fun testSuccessfullyShowPhotoList() {
        robot
            .mockSuccessfulResponse()
            .start()
            .checkSuccessList()
    }

    @Test
    fun testSuccessfullyShowEmptyList() {
        robot
            .mockEmptyResponse()
            .start()
            .checkEmptyList()
    }

}