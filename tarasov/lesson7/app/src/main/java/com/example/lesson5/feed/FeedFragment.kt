package com.example.lesson5.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lesson5.*
import com.example.lesson5.databinding.FragmentFeedBinding
import com.example.lesson5.databinding.ViewContentCardBinding

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
        binding?.apply {
            postAdapter.onItemClicked = {
                findNavController().navigate(
                    FeedFragmentDirections.actionFeedFragment3ToFragmentPost2(it)
                )
            }
            recycler.adapter = postAdapter
            postAdapter.submitList(MockProvider.getMockPosts())
        }
    }
}