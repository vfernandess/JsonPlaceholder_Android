package com.voidx.jsonplaceholder.feature.photo.list

import com.voidx.jsonplaceholder.util.createMockResponse
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

sealed class PhotoListMockFactory {

    object SuccessDispatcher : Dispatcher() {

        override fun dispatch(request: RecordedRequest): MockResponse {
            return when (request.path) {
                "/photos" -> createMockResponse(200, "photo_list_200.json")
                else -> createMockResponse(404)
            }
        }
    }

    object EmptyDispatcher : Dispatcher() {

        override fun dispatch(request: RecordedRequest): MockResponse {
            return when (request.path) {
                "/photos" -> createMockResponse(200, "empty.json")
                else -> createMockResponse(404)
            }
        }
    }

}