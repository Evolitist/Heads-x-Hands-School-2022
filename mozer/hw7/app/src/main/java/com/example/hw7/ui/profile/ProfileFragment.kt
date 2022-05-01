package com.example.hw7.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.hw7.databinding.FragmentProfileBinding
import com.example.hw7.domain.model.Profile
import com.example.hw7.ui.ImagesAdapter
import com.example.hw7.ui.PostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
    private val postAdapter = PostAdapter()
    private val imagesAdapter = ImagesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel.loadData()

        binding.imagesList.apply {
            adapter = imagesAdapter
        }
        viewModel.profileLiveData.observe(viewLifecycleOwner) {
            setProfile(it)
            imagesAdapter.submitList(it.images)
        }

        binding.feedList.apply {
            adapter = postAdapter
        }
        viewModel.postsLiveData.observe(viewLifecycleOwner) {
            postAdapter.submitData(viewLifecycleOwner.lifecycle,it)
        }
    }

    private fun setProfile(profile: Profile) {

        binding.profileImage.isVisible = !profile.avatarSmall.isNullOrBlank()
        binding.profileImage.load(profile.avatarSmall)

        binding.profileName.text = profile.displayName ?: profile.username
        binding.profileBio.text = profile.bio
        binding.imagesCount.text = profile.imagesCount.toString()
        binding.subscribersCount.text = profile.subscribersCount.toString()
        binding.postsCount.text = profile.postsCount.toString()

    }

}