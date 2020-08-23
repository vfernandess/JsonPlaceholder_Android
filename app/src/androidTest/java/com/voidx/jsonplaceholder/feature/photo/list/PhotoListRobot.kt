package com.voidx.jsonplaceholder.feature.photo.list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.voidx.jsonplaceholder.R
import com.voidx.jsonplaceholder.feature.photo.list.view.PhotoListFragment
import com.voidx.jsonplaceholder.util.startNavigation
import com.voidx.jsonplaceholder.util.withRecyclerViewItem
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matchers.not

class PhotoListRobot(private val mockWebServer: MockWebServer) {

    fun start() = apply {
        startNavigation<PhotoListFragment>()
    }

    fun mockSuccessfulResponse() = apply {
        mockWebServer.dispatcher = PhotoListMockFactory.SuccessDispatcher
    }

    fun mockEmptyResponse() = apply {
        mockWebServer.dispatcher = PhotoListMockFactory.SuccessDispatcher
    }

    fun checkEmptyList() = apply {
        onView(withId(R.id.list)).check(matches(not(isDisplayed())))
    }

    fun checkSuccessList() = apply {
        onView(withId(R.id.list)).check(matches(isDisplayed()))
        onView(withRecyclerViewItem(R.id.list, 0, R.id.title)).check(matches(withText("first title")))
    }

}