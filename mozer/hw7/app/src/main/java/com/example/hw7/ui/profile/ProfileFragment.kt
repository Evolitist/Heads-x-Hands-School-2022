package com.example.hw7.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.hw7.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
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

        viewModel.loadProfile()

        viewModel.profileLiveData.observe(viewLifecycleOwner){
            binding.profileImage.load(it.avatarSmall)
            binding.profileName.text = it.displayName ?: it.username
            binding.profileBio.text = it.bio
            binding.imagesCount.text = it.imagesCount.toString()
            binding.subscribersCount.text = it.subscribersCount.toString()
            binding.postsCount.text = it.postsCount.toString()

            binding.item1.setImage(it.images.first().sizes.last().url)
            binding.item2.setImage(it.images.get(1).sizes.last().url)
            binding.item3.setImage(it.images.get(2).sizes.last().url)
            binding.item4.setImage(it.images.get(3).sizes.last().url)
        }
    }
}