package com.example.hw7.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw7.R
import com.example.hw7.data.MockProvider
import com.example.hw7.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {
    private var binding: FragmentFeedBinding? = null
    private val postAdapter = PostAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recycler?.adapter = postAdapter.apply {
            setOnItemClick {
                findNavController().navigate(FeedFragmentDirections.actionFeedFragmentToPostFragment(it.id))
            }
        }
        postAdapter.submitList(MockProvider.getListPosts())
    }
}