package com.voidx.jsonplaceholder.feature.post.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.voidx.jsonplaceholder.databinding.FragmentPostWithCommentsBinding
import com.voidx.jsonplaceholder.feature.post.presentation.PostViewModel
import com.voidx.jsonplaceholder.presentation.State
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class PostWithCommentsFragment : Fragment() {

    private val viewModel: PostViewModel by lifecycleScope.viewModel(this)
    private val adapter: CommentAdapter by lifecycleScope.inject()

    private lateinit var binding: FragmentPostWithCommentsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostWithCommentsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.comments.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state().observe({ lifecycle }) { state ->
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
//        infiniteScrollListener.loading = false
//        binding.loading.visibility = View.GONE
//        binding.list.visibility = View.GONE
    }

    private fun transitionToSuccessState() {
//        infiniteScrollListener.loading = false
//        binding.loading.visibility = View.GONE
//        binding.list.visibility = View.VISIBLE
    }

    private fun transitionToEmptyState() {
//        infiniteScrollListener.loading = false
//        binding.loading.visibility = View.GONE
//        binding.list.visibility = View.GONE
    }

    private fun transitionToLoadingState() {
//        infiniteScrollListener.loading = true
//        binding.loading.visibility = View.VISIBLE
//        binding.list.visibility = View.GONE
    }

}