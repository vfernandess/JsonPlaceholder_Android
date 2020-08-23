package com.voidx.jsonplaceholder.feature.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.voidx.jsonplaceholder.R
import com.voidx.jsonplaceholder.databinding.FragmentHomeBinding
import com.voidx.jsonplaceholder.feature.home.HomeCoordinator
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeFragment : Fragment() {

    private val coordinator: HomeCoordinator by inject {
        parametersOf(findNavController())
    }

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.photos.setOnClickListener { coordinator.showPhotos() }
        binding.posts.setOnClickListener { coordinator.showPosts() }
    }

}