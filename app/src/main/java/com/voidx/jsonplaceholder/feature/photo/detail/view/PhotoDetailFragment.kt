package com.voidx.jsonplaceholder.feature.photo.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.voidx.jsonplaceholder.databinding.FragmentPhotoDetailBinding
import com.voidx.jsonplaceholder.feature.photo.detail.presentation.PhotoDetailViewModel

class PhotoDetailFragment : Fragment() {

    private val viewModel: PhotoDetailViewModel by lazy { PhotoDetailViewModel() }

    private val args: PhotoDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentPhotoDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPhotoDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.load(args.photo)
    }
}