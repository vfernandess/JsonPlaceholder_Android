package com.voidx.jsonplaceholder.feature.photo.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.voidx.jsonplaceholder.databinding.FragmentPhotoListBinding
import com.voidx.jsonplaceholder.feature.photo.list.presentation.PhotoListViewModel
import com.voidx.jsonplaceholder.presentation.State
import com.voidx.jsonplaceholder.view.widget.recyclerview.EndlessRecyclerViewScrollListener
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class PhotoListFragment : Fragment() {

    private val viewModel: PhotoListViewModel by lifecycleScope.viewModel(this)
    private val adapter: PhotoAdapter by lifecycleScope.inject()

    private lateinit var binding: FragmentPhotoListBinding
    private lateinit var infiteScrollListener: EndlessRecyclerViewScrollListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.list.adapter = adapter

        infiteScrollListener = EndlessRecyclerViewScrollListener(
            5,
            EndlessRecyclerViewScrollListener.DIRECTION_BOTTOM,
            binding.list.layoutManager as LinearLayoutManager
        )

        infiteScrollListener.onLoadMore = {
            viewModel.load()
        }

        binding.list.addOnScrollListener(infiteScrollListener)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state().observe({ this.lifecycle }) { state ->
            when (state) {
                State.Loading -> transitionToLoadingState()
                State.Empty -> transitionToEmptyState()
                State.Success -> transitionToSuccessState()
                State.Error -> transitionToErrorState()
            }
        }

        viewModel.load()
    }

    private fun transitionToErrorState() {
        infiteScrollListener.loading = false
        binding.loading.visibility = GONE
        binding.list.visibility = GONE
    }

    private fun transitionToSuccessState() {
        infiteScrollListener.loading = false
        binding.loading.visibility = GONE
        binding.list.visibility = VISIBLE
    }

    private fun transitionToEmptyState() {
        infiteScrollListener.loading = false
        binding.loading.visibility = GONE
        binding.list.visibility = GONE
    }

    private fun transitionToLoadingState() {
        infiteScrollListener.loading = true
        binding.loading.visibility = VISIBLE
        binding.list.visibility = GONE
    }

}