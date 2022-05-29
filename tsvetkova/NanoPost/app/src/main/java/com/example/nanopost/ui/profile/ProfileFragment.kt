package com.example.nanopost.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.nanopost.NavGraphDirections
import com.example.nanopost.R
import com.example.nanopost.databinding.FragmentProfileBinding
import com.example.nanopost.ui.images.ImagesFragmentDirections
import com.example.nanopost.ui.shared.PostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>()
    private val postAdapter = PostAdapter()
    private val args: ProfileFragmentArgs by navArgs()
    private val profileImageAdapter = ProfileImagesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceSaved: Bundle?,
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.init(args.profileId)

        binding.recycler.apply {
            adapter = postAdapter.apply {
                setOnPostClick {
                    val action = NavGraphDirections.actionGlobalPost(it.id)
                    findNavController().navigate(action)
                }

                setOnImageClick {
                    val action = NavGraphDirections.actionGlobalImage(it.id)
                    findNavController().navigate(action)
                }
            }
        }

        binding.profileImages.imageRecycler.apply {
            adapter = profileImageAdapter.apply {
                setOnImageClick {
                    val action = NavGraphDirections.actionGlobalImage(it.id)
                    findNavController().navigate(action)
                }
            }
        }

        binding.profileHeader.avatar.setOnClickListener {
            viewModel.profileLiveData.value?.avatarId?.let {
                val action = NavGraphDirections.actionGlobalImage(it)
                findNavController().navigate(action)
            }

        }

        binding.profileImages.rightArrow.setOnClickListener {
            val profileId = viewModel.profileLiveData.value?.id
            profileId?.let {
                val action = ProfileFragmentDirections.actionProfileFragmentToImagesFragment(it)
                findNavController().navigate(action)
            }

        }

        binding.fab.setOnClickListener {
            val action = NavGraphDirections.actionGlobalCreatePost()
            findNavController().navigate(action)
        }


        viewModel.profileLiveData.observe(viewLifecycleOwner) {
            binding.profileHeader.apply {
                avatar.load(it.avatarSmall)
                displayName.text = it.displayName ?: it.username
                bio.text = it.bio
                imagesCount.text = it.imagesCount.toString()
                subscribersCount.text = it.subscribersCount.toString()
                postsCount.text = it.postsCount.toString()
            }
            profileImageAdapter.submitList(it.images)

        }

        viewModel.postsLiveData.observe(viewLifecycleOwner) {
            postAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
}