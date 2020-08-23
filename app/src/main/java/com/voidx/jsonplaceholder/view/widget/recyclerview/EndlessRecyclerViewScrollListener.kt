package com.voidx.jsonplaceholder.view.widget.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessRecyclerViewScrollListener(
    private val visibleThreshold: Int,
    private val direction: Int,
    private val layoutManager: LinearLayoutManager
) : RecyclerView.OnScrollListener() {

    companion object {
        const val DIRECTION_TOP = 0
        const val DIRECTION_BOTTOM = 1
    }

    var onLoadMore: (() -> Unit)? = null
    var loading = false

    private var isScrollingEnabled: Boolean = false

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        isScrollingEnabled = newState != RecyclerView.SCROLL_STATE_IDLE
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val totalItemCount = layoutManager.itemCount
        val visibleItem = getVisibleItem()
        if (!loading &&
            totalItemCount > 0 &&
            visibleItem > -1 &&
            hasToLoadMore(visibleItem, totalItemCount) &&
            isScrollingEnabled
        ) {
            onLoadMore?.invoke()
            loading = true
        }
    }

    private fun getVisibleItem(): Int {
        return when (direction) {
            DIRECTION_TOP -> {
                layoutManager.findFirstVisibleItemPosition()
            }
            DIRECTION_BOTTOM -> {
                layoutManager.findLastVisibleItemPosition()
            }
            else -> {
                -1
            }
        }
    }

    private fun hasToLoadMore(visibleItem: Int, totalItemCount: Int): Boolean {
        return when (direction) {
            DIRECTION_TOP -> {
                (visibleItem - visibleThreshold) <= 0
            }
            DIRECTION_BOTTOM -> {
                totalItemCount <= (visibleItem + visibleThreshold)
            }
            else -> {
                false
            }
        }
    }

}