package com.voidx.jsonplaceholder.feature.photo.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.voidx.jsonplaceholder.databinding.FragmentPhotoListBinding
import com.voidx.jsonplaceholder.feature.photo.list.PhotoListCoordinator
import com.voidx.jsonplaceholder.feature.photo.list.presentation.PhotoListViewModel
import com.voidx.jsonplaceholder.presentation.State
import com.voidx.jsonplaceholder.view.widget.recyclerview.EndlessRecyclerViewScrollListener
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.parameter.parametersOf

class PhotoListFragment : Fragment() {

    private val viewModel: PhotoListViewModel by lifecycleScope.viewModel(this)
    private val adapter: PhotoAdapter by lifecycleScope.inject()
    private val coordinator: PhotoListCoordinator by lifecycleScope.inject {
        parametersOf(findNavController())
    }

    private lateinit var binding: FragmentPhotoListBinding
    private lateinit var infiniteScrollListener: EndlessRecyclerViewScrollListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPhotoListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.list.adapter = adapter
        adapter.onClick = viewModel::showDetail

        infiniteScrollListener = EndlessRecyclerViewScrollListener(
            5,
            EndlessRecyclerViewScrollListener.DIRECTION_BOTTOM,
            binding.list.layoutManager as LinearLayoutManager
        )

        infiniteScrollListener.onLoadMore = {
            viewModel.load()
        }

        binding.list.addOnScrollListener(infiniteScrollListener)

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

        viewModel.onItemClick.observe({ lifecycle }) { photo ->
            coordinator.showDetail(photo)
        }

        viewModel.load()
    }

    private fun transitionToErrorState() {
        infiniteScrollListener.loading = false
        binding.loading.visibility = GONE
        binding.list.visibility = GONE
    }

    private fun transitionToSuccessState() {
        infiniteScrollListener.loading = false
        binding.loading.visibility = GONE
        binding.list.visibility = VISIBLE
    }

    private fun transitionToEmptyState() {
        infiniteScrollListener.loading = false
        binding.loading.visibility = GONE
        binding.list.visibility = GONE
    }

    private fun transitionToLoadingState() {
        infiniteScrollListener.loading = true
        binding.loading.visibility = VISIBLE
        binding.list.visibility = GONE
    }

}